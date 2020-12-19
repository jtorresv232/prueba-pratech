package com.pratechtest.pratechtestbackend.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;

public interface IQuestionService {
	ResponseEntity<String> getAllByFormId(int id);
	ResponseEntity<String> getAllByFormIdAndUser(int formid, int userid);
	ResponseEntity<String> answerQuestion(AddQuestionDTORequest question);
	ResponseEntity<String> answerAllQuestions(List<AddQuestionDTORequest> questions);
	ResponseEntity<String> getAllByTry(int tryid);
}
