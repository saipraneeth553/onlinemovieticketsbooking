package com.movie.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.movie.entity.seats;
@Component
@EnableJpaRepositories
public interface SeatRepository extends JpaRepository<seats, Long>{

	@Query("select s.seatNo from seats s where s.mname=?1 and s.cinemaHallName=?2 and  s.time=?3")
	List<Long> getseatByMTS(String m, String t, LocalTime st);
	

}
