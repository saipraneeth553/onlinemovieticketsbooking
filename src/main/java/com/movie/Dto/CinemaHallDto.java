package com.movie.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CinemaHallDto {

	private Long id;
	private String name;
	 private String location;
	 private String movieName;
}
