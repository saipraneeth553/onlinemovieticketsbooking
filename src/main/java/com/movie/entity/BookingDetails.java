package com.movie.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Booking")
public class BookingDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Book_Id")
	@NotNull
	private long id;
	
	@Column(name="Book_Date")
	private LocalDateTime date;
	@Column(name="Book_Time")
	private LocalTime time;
	@Column(name="Book_Amt")
	private Long amount;
	@Column(name="Book_cnt")
	private Long count;
	@Column(name="Book_SD")
	private LocalDate showDate;
	@Column(name="Book_ST")
	private  LocalTime showTime;
	@Column(name="Book_Movie")
	private String movie;
	@Column(name="Book_Status")
	private String status;
	@Column(name="Book_Seats")
	private String seats;
	@Column(name="Book_Email")
	private String email;
	
	
	
	
	
	
	
	}
