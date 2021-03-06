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
@Table(name="validation")
public class Validation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	@GsonExcludeProperty
	private Question question;
	
	public Validation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Validation(int id, String type, String value) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
	}

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
