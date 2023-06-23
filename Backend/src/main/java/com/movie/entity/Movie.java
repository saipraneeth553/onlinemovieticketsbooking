package com.movie.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Mov_Id")
    @NotNull
	private Long id;
	@Column(name="Mov_itle")
	private String title;
	@Column(name="Mov_Date")
	private LocalDate date;
	@Column(name="Mov_Length")
	private int length;
	@Column(name="Mov_Category")
	private String category;
	@Column(name="Mov_Language")
	private String language;
	
	@Column(name="Mov_Cast")
	private String cast;
	@Column(name="Mov_Img")
	private String img;
	@Column(name="Mov_Status")
	private String status;
	@Column(name="Admin_email")
	private String email;
	
	
	

}
