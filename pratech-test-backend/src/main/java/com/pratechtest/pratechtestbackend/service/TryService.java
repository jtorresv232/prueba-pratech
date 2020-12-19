package com.pratechtest.pratechtestbackend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratechtest.pratechtestbackend.dto.response.TryDTOResponse;
import com.pratechtest.pratechtestbackend.dto.response.TryQuestionDto;
import com.pratechtest.pratechtestbackend.entity.Answer;
import com.pratechtest.pratechtestbackend.entity.Question;
import com.pratechtest.pratechtestbackend.entity.Try;
import com.pratechtest.pratechtestbackend.irepository.ITryRepository;
import com.pratechtest.pratechtestbackend.iservice.ITryService;
import com.pratechtest.pratechtestbackend.response.FinalResponse;

@Service
public class TryService implements ITryService{
	
	@Autowired FinalResponse finalResponse;
	@Autowired ITryRepository tryRepository;
	private HttpHeaders httpHeaders = new HttpHeaders();

	@Override
	public ResponseEntity<String> getAllTriesByUser(int userid) {
		List<Try> userTries = tryRepository.findAllByUser(userid);
		List<TryDTOResponse> tryResponses = new ArrayList<TryDTOResponse>();
		TryDTOResponse dto;
		Question question;
		tryResponses = new ArrayList<TryDTOResponse>();
		TryQuestionDto questionResponse;
		for(Try userTry : userTries) {
			Set<TryQuestionDto> questions = new HashSet<TryQuestionDto>();
			Set<Answer> answers;
			for(Answer answre : userTry.getAnswer()) {
				question = answre.getQuestion();
				answers= new HashSet<Answer>();
				answers.add(answre);
				questionResponse = new TryQuestionDto(question.getId(), question.getType(), question.getQuestion(), question.getValidations(), answre);
				/*if(answre.getUsertry().getId() == userTry.getId() ) {
					answers.add(answre);
					question.setAnswer(answers);
					questions.add(question);
				}*/
				questions.add(questionResponse);
			}
			dto = new TryDTOResponse(userTry.getId(), questions);
			tryResponses.add(dto);
		}
		return finalResponse.getResponse(tryResponses, httpHeaders, HttpStatus.OK).toResponseEntity();
	}

	@Override
	public ResponseEntity<String> deleteTry(int tryid) {
		try {
			tryRepository.deleteById(tryid);
			return finalResponse.getResponse("Se ha eliminado el registro exitosamente", httpHeaders, HttpStatus.OK).toResponseEntity();
		}catch(Exception e) {
			return finalResponse.getResponse("No Se ha podido eliminar el registro", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR).toResponseEntity();
		}
	}

}
