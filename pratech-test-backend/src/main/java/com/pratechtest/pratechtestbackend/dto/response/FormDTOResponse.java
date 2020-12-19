package com.pratechtest.pratechtestbackend.dto.response;

import java.util.Set;
import com.pratechtest.pratechtestbackend.entity.Question;


public class FormDTOResponse {
	
	private Integer id;
	private String name;
	private Set<Question> questions;
	
	
	public FormDTOResponse(Integer id, String name, Set<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.questions = questions;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
}
