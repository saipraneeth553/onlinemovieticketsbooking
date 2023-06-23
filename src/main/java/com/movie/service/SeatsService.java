package com.movie.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.seats;
import com.movie.repository.SeatRepository;

@Service
@Transactional
public class SeatsService {

	@Autowired
	SeatRepository sRepository;

	public boolean insert(seats seat) {
		sRepository.save(seat);
		return true;
	}

	public List<seats> getAllSeats() {
		return sRepository.findAll();
	}

	public List<Long> getSeatBymts(String m,String t,LocalTime st) {
		return sRepository.getseatByMTS(m,t,st);
	}
}
