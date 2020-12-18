package com.pratechtest.pratechtestbackend.dto.request;

public class AddQuestionDTORequest {
	private int id;
	private String answer;
		
	public AddQuestionDTORequest(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public AddQuestionDTORequest() {
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
	
	
}
