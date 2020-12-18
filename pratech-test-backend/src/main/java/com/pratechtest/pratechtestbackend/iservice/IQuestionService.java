package com.pratechtest.pratechtestbackend.iservice;

import org.springframework.http.ResponseEntity;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;

public interface IQuestionService {
	ResponseEntity<String> getAllByFormId(int id);
	ResponseEntity<String> getAllByFormIdAndUser(int formid, int userid);
	ResponseEntity<String> answerQuestion(AddQuestionDTORequest question);
}
