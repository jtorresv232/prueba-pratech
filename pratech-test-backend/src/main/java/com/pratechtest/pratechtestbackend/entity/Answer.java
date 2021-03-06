package com.pratechtest.pratechtestbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	@GsonExcludeProperty
	private Question question;
	
	@ManyToOne
	@JoinColumn(name="try_id")
	@GsonExcludeProperty
	private Try usertry;
	
	public Answer(String answer, Question question) {
		super();
		this.answer = answer;
		this.question = question;
	}
	
	public Answer(int id, String answer, Question question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Try getUsertry() {
		return usertry;
	}

	public void setUsertry(Try usertry) {
		this.usertry = usertry;
	}
	
	
	
}
