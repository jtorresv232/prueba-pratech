package com.pratechtest.pratechtestbackend.dto.response;

import java.util.List;
import java.util.Set;

import com.pratechtest.pratechtestbackend.entity.Question;
import com.pratechtest.pratechtestbackend.entity.User;


public class FormDTOResponse {
	
	private Integer id;
	private User user_id;
	private String name;
	private Set<Question> questions;
	
	
	public FormDTOResponse(Integer id, User user_id, String name, Set<Question> questions) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.questions = questions;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
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
