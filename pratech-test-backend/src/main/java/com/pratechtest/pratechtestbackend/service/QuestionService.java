package com.pratechtest.pratechtestbackend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;
import com.pratechtest.pratechtestbackend.dto.response.AddQuestionDTOResponse;
import com.pratechtest.pratechtestbackend.dto.response.QuestionDTOResponse;
import com.pratechtest.pratechtestbackend.entity.Answer;
import com.pratechtest.pratechtestbackend.entity.Question;
import com.pratechtest.pratechtestbackend.entity.Try;
import com.pratechtest.pratechtestbackend.entity.User;
import com.pratechtest.pratechtestbackend.irepository.IAnswerRepository;
import com.pratechtest.pratechtestbackend.irepository.IQuestionRepository;
import com.pratechtest.pratechtestbackend.irepository.ITryRepository;
import com.pratechtest.pratechtestbackend.irepository.IUserRepository;
import com.pratechtest.pratechtestbackend.iservice.IQuestionService;
import com.pratechtest.pratechtestbackend.response.FinalResponse;

@Service
public class QuestionService implements IQuestionService{
	
	@Autowired FinalResponse finalResponse;
	@Autowired IQuestionRepository questionRepository;
	@Autowired IUserRepository userRepository;
	@Autowired ITryRepository tryRepository;
	@Autowired IAnswerRepository answerRepository;
	private HttpHeaders httpHeaders = new HttpHeaders();

	@Override
	public ResponseEntity<String> getAllByFormId(int formId) {
		List<Question> foundQuestions = questionRepository.findByFormId(formId);
		List<QuestionDTOResponse> questionsDTOList = new ArrayList<QuestionDTOResponse>();
		QuestionDTOResponse questionDto;
		for(Question foundQuestion : foundQuestions) {
			questionDto = new QuestionDTOResponse(foundQuestion.getId(), foundQuestion.getQuestion(), foundQuestion.getType(), foundQuestion.getValidations());
			questionsDTOList.add(questionDto);
		}
		return finalResponse.getResponse(questionsDTOList, httpHeaders, HttpStatus.OK).toResponseEntity();
	}
	
	@Override
	public ResponseEntity<String> getAllByFormIdAndUser(int formid, int userid) {
		List<Question> foundQuestions = questionRepository.findByFormAndUser(formid, userid);
		List<QuestionDTOResponse> questionsDTOList = new ArrayList<QuestionDTOResponse>();
		QuestionDTOResponse questionDto;
		for(Question foundQuestion : foundQuestions) {
			questionDto = new QuestionDTOResponse(foundQuestion.getId(), foundQuestion.getQuestion(), foundQuestion.getType(), foundQuestion.getValidations(), foundQuestion.getAnswer().iterator().next());
			questionsDTOList.add(questionDto);
		}
		return finalResponse.getResponse(questionsDTOList, httpHeaders, HttpStatus.OK).toResponseEntity();
	}

	@Override
	public ResponseEntity<String> answerQuestion(AddQuestionDTORequest question) {
		Optional<Question> questionFound = questionRepository.findById(question.getId());
		if(!questionFound.isPresent()) {
			return finalResponse.getResponse("No se ha encontrado la pregunta a actualizar", httpHeaders, HttpStatus.NOT_FOUND).toResponseEntity();
		}
		Question dbQuestion = questionFound.get();
		Answer answer;
		if(question.getAnswerId() != null) {
			answer = answerRepository.getOne(question.getAnswerId());
			answer.setAnswer(question.getAnswer());
		}else {
			answer = new Answer(question.getAnswerId(), question.getAnswer(), dbQuestion);
		}
		if(question.getUsertry() != null) {
			Set<Answer> answers = new HashSet<Answer>();
			answers.add(answer);
			User user = userRepository.getOne(question.getUserId());
			Try usertry = new Try(question.getUsertry(), user, answers);
			answer.setUsertry(usertry);
		} else {
			Set<Answer> answers = new HashSet<Answer>();
			answers.add(answer);
			User user = userRepository.getOne(question.getUserId());
			Try usertry = new Try(user, answers);
			Try newTry = tryRepository.save(usertry);
			answer.setUsertry(newTry);
		}
		dbQuestion.getAnswer().add(answer);
		try {
			questionRepository.save(dbQuestion);
		} catch(Exception e){
			System.out.println(e);
			return finalResponse.getResponse("Ha ocurrido un error actualizando la pregunta", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR).toResponseEntity();
		}
		return finalResponse.getResponse(new AddQuestionDTOResponse(answer.getId(), answer.getUsertry().getId()), httpHeaders, HttpStatus.OK).toResponseEntity();
	}

	@Override
	public ResponseEntity<String> answerAllQuestions(List<AddQuestionDTORequest> questions) {
		Try userTry;
		User user;
		user = userRepository.getOne(questions.get(0).getUserId());
		Set<Answer> answers = new HashSet<Answer>();
		Answer answer;
		if(questions.get(0).getUsertry() != null) {
			userTry = new Try(questions.get(0).getUsertry(), user);
			for(AddQuestionDTORequest question: questions) {
				if(question.getAnswerId() != null) {
					answer = answerRepository.getOne(question.getAnswerId());
					answer.setAnswer(question.getAnswer());
					answers.add(answer);
				}else {
					Optional<Question> questionFound = questionRepository.findById(question.getId());
					answer = new Answer( question.getAnswer(), questionFound.get());
					answers.add(answer);
				}
			}
		}else {
			userTry = tryRepository.save(new Try(user));
			for(AddQuestionDTORequest question: questions) {
				if(question.getAnswerId() != null) {
					answer = answerRepository.getOne(question.getAnswerId());
					answer.setAnswer(question.getAnswer());
					answer.setUsertry(userTry);
					answers.add(answer);
				}else {
					Optional<Question> questionFound = questionRepository.findById(question.getId());
					answer = new Answer(question.getAnswer(), questionFound.get());
					answer.setUsertry(userTry);
					answers.add(answer);
				}
			}
		}
		
		try {
			answerRepository.saveAll(answers);
		} catch(Exception e){
			System.out.println(e);
			return finalResponse.getResponse("Ha ocurrido un error actualizando la pregunta", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR).toResponseEntity();
		}
		
		return finalResponse.getResponse("Las Preguntas se han guardado correctamente", httpHeaders, HttpStatus.OK).toResponseEntity();
	}

	@Override
	public ResponseEntity<String> getAllByTry(int tryid) {
		List<Question> foundQuestions = questionRepository.findByTry(tryid);
		List<QuestionDTOResponse> questionsDTOList = new ArrayList<QuestionDTOResponse>();
		QuestionDTOResponse questionDto;
		for(Question foundQuestion : foundQuestions) {
			Set<Answer> answers = foundQuestion.getAnswer();
			Answer answer = new Answer();
			for(Answer ans : answers) {
				if(ans.getUsertry().getId() == tryid) {
					answer = ans;
					break;
				}
			}
			questionDto = new QuestionDTOResponse(foundQuestion.getId(), foundQuestion.getQuestion(), foundQuestion.getType(), foundQuestion.getValidations(),answer);
			questionsDTOList.add(questionDto);
		}
		return finalResponse.getResponse(questionsDTOList, httpHeaders, HttpStatus.OK).toResponseEntity();
	}
	
}
