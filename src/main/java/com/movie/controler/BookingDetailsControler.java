package com.movie.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.BookingDetails;
import com.movie.service.bookingDetailsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class BookingDetailsControler {

	@Autowired
	bookingDetailsService objBookingDetailsDaoImpl;
	
	
	@PostMapping("/Booking/add")
    public boolean insert(@RequestBody BookingDetails bd) {
		return objBookingDetailsDaoImpl.insert(bd);
			
	}
	@PutMapping("/Booking/update")
	public boolean update(@RequestBody BookingDetails bd) {
		return objBookingDetailsDaoImpl.update(bd);
	}
	@GetMapping("/Booking/getById/{bookingDetailId}")
	public BookingDetails getBookingDetailById(@PathVariable Long bookingDetailId) {
		return objBookingDetailsDaoImpl.getBookingDetailById(bookingDetailId);
	}

	
	@GetMapping("/Booking/del/{bookingDetailsId}")
	public boolean delete(@PathVariable Long bookingDetailsId) {
	     return objBookingDetailsDaoImpl.delete(bookingDetailsId);
	 
	}
	@GetMapping("/Booking/getAll/{email}")
	public List<BookingDetails> getAllBookingByUser(@PathVariable String email){
		
		return objBookingDetailsDaoImpl.getAllBookingByUser(email);
	}
	@GetMapping("/Booking/getdetails/{email}")
	public List<BookingDetails> getlastBookingByUser(@PathVariable String email){
		
		return objBookingDetailsDaoImpl.getlastBookingByUser(email);
	}
}
