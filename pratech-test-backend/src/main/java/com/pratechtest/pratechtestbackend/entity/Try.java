package com.pratechtest.pratechtestbackend.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table()
public class Try {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@GsonExcludeProperty
	private User user;
	
	@OneToMany(mappedBy = "usertry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Answer> answer;
	
	
	public Try(Integer id, User user, Set<Answer> answer) {
		super();
		this.id = id;
		this.user = user;
		this.answer = answer;
	}
	
	public Try(User user, Set<Answer> answer) {
		super();
		this.user = user;
		this.answer = answer;
	}
	
	public Try(User user) {
		super();
		this.user = user;
	}
	
	public Try(Integer id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	
	public Try() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}
	
	

}
