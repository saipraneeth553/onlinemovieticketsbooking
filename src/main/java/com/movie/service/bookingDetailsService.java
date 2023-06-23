package com.movie.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.hibernate.dialect.DB2390Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.Dto.BookingDEtailsDto;
import com.movie.Dto.userDto;
import com.movie.controler.UserContoler;
import com.movie.entity.BookingDetails;
import com.movie.entity.cinemaHall;
import com.movie.exceptions.CustomException;
import com.movie.repository.BookingRepository;

@Service
@Transactional
public class bookingDetailsService {

	@Autowired
	BookingRepository bboj;
	Logger logger=LoggerFactory.getLogger(bookingDetailsService.class);
	
	
		public boolean insert(BookingDetails bd){
		if(bd.getEmail()==null) {
			logger.error("error at insertion");
			throw new CustomException("Give all details of booking details properly");
		}
		bboj.save(bd);
		return true;
		
	}
	public List<BookingDetails> getlastBookingByUser(String email) {
		
		
			List<BookingDetails> k=bboj.getlastBookingByUser(email);
		if(k.size()==0) {
			throw new CustomException("No Booking Derails with given Email");
		}
		logger.info("Data succesfully taken ");
		return k;

	}
	public List<BookingDetails> getAllBookingByUser(String email) {
		
		
		List<BookingDetails> k=bboj.getAllBookingByUser(email);
	if(k.size()==0) {
		throw new CustomException("No Booking Derails with given Email");
	}
	return k;

}

public List<BookingDetails> getAllBookingDeatails() {
	
		List<BookingDetails> k=bboj.findAll();
		if(k.size()==0) {
			logger.error("No Data avalible");
			throw new CustomException("No data Avalible");
		}
		return bboj.findAll();
	
	}
	public boolean delete(long bookingDetailsId) {
		if(bboj.findById(bookingDetailsId).isEmpty())
			throw new CustomException("Given Booking ID"+bookingDetailsId+" is not there to Delete from data ");
		bboj.deleteById(bookingDetailsId);
		logger.info("Data deleted succesfully");
		return true;
	}
	public boolean update(BookingDetails bd) {
		BookingDetails exixtBook=bboj.findById(bd.getId()).orElse(null);
		
		if(exixtBook==null) 
			throw new CustomException("Given the Booking details of saved data to modify");
		
		 exixtBook.setAmount(bd.getAmount());
		 exixtBook.setCount(bd.getCount());
		 exixtBook.setDate(bd.getDate());
		 exixtBook.setEmail(bd.getEmail());
		 exixtBook.setMovie(bd.getMovie());
		 exixtBook.setSeats(bd.getSeats());
		 exixtBook.setShowDate(bd.getShowDate());
		 exixtBook.setShowTime(bd.getShowTime());
		 exixtBook.setStatus(bd.getStatus());
		 exixtBook.setTime(bd.getTime());
		 bboj.save(exixtBook);
		 return true;
	}
	public BookingDetails getBookingDetailById(Long bookingDetailId) {
		
			if(bboj.findById(bookingDetailId).isEmpty())
				        throw new NoSuchElementException();
		return bboj.findById(bookingDetailId).get();
		
	}
   

	
}
