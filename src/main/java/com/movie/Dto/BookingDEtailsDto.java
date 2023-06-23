package com.movie.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDEtailsDto {

	private long id;
	private LocalDate date;
	private LocalTime time;
	private Long amount;
	private Long count;
	private LocalDate showDate;
	private  LocalTime showTime;
	private String movie;
	private String status;
	private long seats;
	private String email;
	
}
