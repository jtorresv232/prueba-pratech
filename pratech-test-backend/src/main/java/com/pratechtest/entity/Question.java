package com.pratechtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=false)
	private String question;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int id, String type, String question) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
