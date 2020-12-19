package com.pratechtest.pratechtestbackend.dto.response;

import java.util.Set;

import com.pratechtest.pratechtestbackend.entity.Answer;
import com.pratechtest.pratechtestbackend.entity.Validation;

public class TryQuestionDto {
	private int id;
	private String type;
	private String question;
	private Set<Validation> validations;
	private Answer answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
	public TryQuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TryQuestionDto(int id, String type, String question, Set<Validation> validations, Answer answer) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
		this.validations = validations;
		this.answer = answer;
	}
	
	

}
