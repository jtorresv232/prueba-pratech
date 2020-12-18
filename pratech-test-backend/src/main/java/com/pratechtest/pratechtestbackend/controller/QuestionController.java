package com.pratechtest.pratechtestbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;
import com.pratechtest.pratechtestbackend.iservice.IQuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired IQuestionService questionService;
	
	@RequestMapping("/{formId}")
	public ResponseEntity<String> getQuestionsByFormId(@PathVariable("formId") int formid) {
		return questionService.getAllByFormId(formid);
	}
	
	@RequestMapping(value = "/answer/{questionId}", method = RequestMethod.POST)
	public ResponseEntity<String> answerQuestion(@RequestBody AddQuestionDTORequest question) {
		return questionService.answerQuestion(question);
	}
}
