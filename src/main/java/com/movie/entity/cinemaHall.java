package com.movie.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cinemasname")
public class cinemaHall {
	@Id
	@NotNull
	@Column(name="CinemaHall_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	
	@Column(name="CinemaHall_Name")
	private String name;
	
	
	@Column(name="Cinema_Location")
	 private String location;
	
	private String movieName;
	
	@Column(name="Cinema_ST1")
	private  LocalTime t1=LocalTime.of(9, 0);
	@Column(name="Cinema_ST2")
	private  LocalTime t2=LocalTime.of(12, 0);
	@Column(name="Cinema_ST3")
	private  LocalTime t3=LocalTime.of(15, 0);
	@Column(name="Cinema_ST4")
	private  LocalTime t4=LocalTime.of(18, 0);
	@Column(name="Cinema_ST5")
	private  LocalTime t5=LocalTime.of(21, 0);
	
	private int noOfSeats;
	
	private LocalDate date;

    private String email;
	
	
   
}
