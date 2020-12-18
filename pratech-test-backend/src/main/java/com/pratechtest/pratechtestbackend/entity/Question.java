package com.pratechtest.pratechtestbackend.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



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
	
	@ManyToOne
	@JoinColumn(name="form_id")
	@GsonExcludeProperty
	private Form formu;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Validation> validations;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
	@GsonExcludeProperty
	private Answer answer;

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
	
	

	public Form getForm() {
		return formu;
	}
	
	

	public Form getFormu() {
		return formu;
	}

	public void setFormu(Form formu) {
		this.formu = formu;
	}

	public void setForm(Form form) {
		this.formu = form;
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
