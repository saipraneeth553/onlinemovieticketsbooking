package com.movie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.cinemaHall;

@Repository
public interface CinemaRepository extends JpaRepository<cinemaHall, Long>{

	@Query(value="select * from cinemas_Hall where movie_name=?1 and date>=?2",nativeQuery = true)
	List<cinemaHall> findByMovieName(String moviename,LocalDate d);

	

}
