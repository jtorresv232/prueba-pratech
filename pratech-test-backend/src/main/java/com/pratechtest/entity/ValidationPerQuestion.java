package com.pratechtest.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="validation_x_question")
public class ValidationPerQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id",referencedColumnName="id", nullable=true, insertable=true, updatable=true)
	private Question question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="validation_id",referencedColumnName="id", nullable=true, insertable=true, updatable=true)
	private Validation validation;

	public ValidationPerQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationPerQuestion(int id, Question question, Validation validation) {
		super();
		this.id = id;
		this.question = question;
		this.validation = validation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	
	
}
