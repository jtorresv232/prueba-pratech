package com.pratechtest.pratechtestbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratechtest.pratechtestbackend.dto.request.AddQuestionDTORequest;
import com.pratechtest.pratechtestbackend.iservice.IQuestionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired IQuestionService questionService;
	
	@RequestMapping("/{formId}")
	public ResponseEntity<String> getQuestionsByFormId(@PathVariable("formId") int formid) {
		return questionService.getAllByFormId(formid);
	}
	
	@RequestMapping("/{formId}/{userid}")
	public ResponseEntity<String> getQuestionsByFormIdAndUser(@PathVariable("formId") int formid, @PathVariable("userid") int userid) {
		return questionService.getAllByFormIdAndUser(formid, userid);
	}
	
	@RequestMapping(value = "/answer/{questionId}", method = RequestMethod.POST)
	public ResponseEntity<String> answerQuestion(@RequestBody AddQuestionDTORequest question) {
		return questionService.answerQuestion(question);
	}
	
	@RequestMapping(value = "/all/answer", method = RequestMethod.POST)
	public ResponseEntity<String> answerAllQuestions(@RequestBody List<AddQuestionDTORequest> questions) {
		return questionService.answerAllQuestions(questions);
	}
	
	@RequestMapping("/byTry/{try}")
	public ResponseEntity<String> getQuestionsByTry(@PathVariable("try") int tryid) {
		return questionService.getAllByTry(tryid);
	}
}
