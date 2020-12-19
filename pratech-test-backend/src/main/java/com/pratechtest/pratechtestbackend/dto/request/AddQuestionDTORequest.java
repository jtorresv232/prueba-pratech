package com.pratechtest.pratechtestbackend.dto.request;

public class AddQuestionDTORequest {
	private Integer id;
	private String answer;
	private int userId;
	private Integer usertry;
	private Integer answerId;
		
	public AddQuestionDTORequest(Integer id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	
	
	public AddQuestionDTORequest(Integer id, String answer, int userId) {
		super();
		this.id = id;
		this.answer = answer;
		this.userId = userId;
	}


	public AddQuestionDTORequest(Integer id, String answer, int userId, Integer usertry) {
		super();
		this.id = id;
		this.answer = answer;
		this.userId = userId;
		this.usertry = usertry;
	}
	
	


	public AddQuestionDTORequest(Integer id, String answer, int userId, Integer usertry, Integer answerId) {
		super();
		this.id = id;
		this.answer = answer;
		this.userId = userId;
		this.usertry = usertry;
		this.answerId = answerId;
	}


	public AddQuestionDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Integer getUsertry() {
		return usertry;
	}


	public void setUsertry(Integer usertry) {
		this.usertry = usertry;
	}


	public Integer getAnswerId() {
		return answerId;
	}


	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	
	
	
}
