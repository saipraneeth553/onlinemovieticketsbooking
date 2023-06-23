package com.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
@Entity
@Table(name="Feedback")
public class Feedback {
	
	
	@Id
	@Column(name="Fed_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private long id;
	@Column(name="Feed_Email")
	private String email;
	@Column(name="user_name")
	private String name;
	@Column(name="User_Feedback")
	private String feedback;
	
	public Feedback(@NotNull long id, String email, String name ,String feedback) {
		super();
		this.id = id;
		this.email = email;
		this.name=name;
		this.feedback = feedback;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
