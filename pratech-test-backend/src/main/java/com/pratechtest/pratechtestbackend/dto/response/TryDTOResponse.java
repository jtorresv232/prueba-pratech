package com.pratechtest.pratechtestbackend.dto.response;

import java.util.Set;


public class TryDTOResponse {
	private int id;
	private Set<TryQuestionDto>questions;
	public TryDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TryDTOResponse(int id, Set<TryQuestionDto> questions) {
		super();
		this.id = id;
		this.questions = questions;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<TryQuestionDto> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<TryQuestionDto> questions) {
		this.questions = questions;
	}
	
	
	
	
}
