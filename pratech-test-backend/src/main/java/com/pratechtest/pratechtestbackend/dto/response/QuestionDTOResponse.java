package com.pratechtest.pratechtestbackend.dto.response;

import java.util.Set;

import com.pratechtest.pratechtestbackend.entity.Answer;
import com.pratechtest.pratechtestbackend.entity.Validation;

public class QuestionDTOResponse {
	
	private int id;
	private String question;
	private String type;
	private Set<Validation> validations;
	private Answer answer;
	
	public QuestionDTOResponse(int id, String question, String type, Set<Validation> validations, Answer answer) {
		super();
		this.id = id;
		this.question = question;
		this.type = type;
		this.validations = validations;
		this.answer = answer;
	}
	public QuestionDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Validation> getValidations() {
		return validations;
	}
	public void setValidations(Set<Validation> validations) {
		this.validations = validations;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
	
}
