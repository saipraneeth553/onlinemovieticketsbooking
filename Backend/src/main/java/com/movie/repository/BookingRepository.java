package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie.entity.BookingDetails;

public interface BookingRepository extends JpaRepository<BookingDetails, Long>{
	
	@Query("Select b from BookingDetails b where email=?1 and date=(select max(b.date) from BookingDetails b)")
	public List<BookingDetails> getlastBookingByUser(String email);
	@Query("Select b from BookingDetails b where email=?1 order by date desc")
	public List<BookingDetails> getAllBookingByUser(String email);
	
}
