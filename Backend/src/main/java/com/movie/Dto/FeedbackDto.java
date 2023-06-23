package com.movie.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackDto {
	
	private long id;
	private String email;
	private String date;
	private String feedback;
}
