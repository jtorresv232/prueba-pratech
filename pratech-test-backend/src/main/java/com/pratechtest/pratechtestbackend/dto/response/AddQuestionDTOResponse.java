package com.pratechtest.pratechtestbackend.dto.response;

public class AddQuestionDTOResponse {

	private int answerId;
	private int usertry;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getUsertry() {
		return usertry;
	}
	public void setUsertry(int usertry) {
		this.usertry = usertry;
	}
	public AddQuestionDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddQuestionDTOResponse(int answerId, int usertry) {
		super();
		this.answerId = answerId;
		this.usertry = usertry;
	}
	
	
}
