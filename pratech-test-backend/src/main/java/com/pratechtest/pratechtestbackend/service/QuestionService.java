package com.pratechtest.pratechtestbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;
import com.pratechtest.pratechtestbackend.dto.response.QuestionDTOResponse;
import com.pratechtest.pratechtestbackend.entity.Answer;
import com.pratechtest.pratechtestbackend.entity.Question;
import com.pratechtest.pratechtestbackend.irepository.IQuestionRepository;
import com.pratechtest.pratechtestbackend.iservice.IQuestionService;
import com.pratechtest.pratechtestbackend.response.FinalResponse;

@Service
public class QuestionService implements IQuestionService{
	
	@Autowired FinalResponse finalResponse;
	@Autowired IQuestionRepository questionRepository;
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
		Answer answer = new Answer(question.getAnswer(), dbQuestion);
		dbQuestion.getAnswer().add(answer);
		
		try {
			questionRepository.save(dbQuestion);
		} catch(Exception e){
			return finalResponse.getResponse("Ha ocurrido un error actualizando la pregunta", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR).toResponseEntity();
		}
		return finalResponse.getResponse("Se ha guardado la respuesta correctamente", httpHeaders, HttpStatus.OK).toResponseEntity();
	}

	

}
