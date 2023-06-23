package com.movie.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {

	private Long id;
	private String title;
	private LocalDate date;
	private int length;
	private String category;
	private String language;
	private String description;
	private String cast;
	private String img;
	private String status;
}


