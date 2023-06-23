package com.movie.Dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.movie.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class userDto {
	private int id;
	private String email;
	private String name;
	private String password;
	private String roleString;
	
}
