package com.movie.entity;

import java.time.LocalTime;

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
@Table(name="Seats")
public class seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Seat_id")
	@NotNull
	private long id;
	@Column(name="CinemaHallName")
	private String cinemaHallName;
	@Column(name="Show_Time")
	private LocalTime time;
	@Column(name="s_No")
	private long seatNo;
	@Column(name="m_name")
	private String mname;
	
	

	
}
