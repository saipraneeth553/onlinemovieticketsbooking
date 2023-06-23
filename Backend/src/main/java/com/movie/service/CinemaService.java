package com.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.movie.entity.cinemaHall;
import com.movie.exceptions.CustomException;
import com.movie.repository.CinemaRepository;


@Service
@Transactional
public class CinemaService  {

	@Autowired
	CinemaRepository cr;
	
	Logger logger=LoggerFactory.getLogger(CinemaService.class);
	 public boolean insert(cinemaHall cinema) {
		 
		 cr.save(cinema);
			 
		 return true;
		 
	 }
	 
	 public List<cinemaHall> getAllCinemas(){
		 List<cinemaHall>cinemas=new ArrayList<>();
		 cinemas=cr.findAll();
		 if(cinemas.size()==0) {
			 throw new CustomException("No data found ");
		 }
;		 logger.info("Data retrived succesfully");
		 return cr.findAll();
	 }
	 public String deleteCinema(long cinemaId) {
		 if(cr.findById(cinemaId).isEmpty()) {
				throw new CustomException("Given cinema ID"+cinemaId+" is not there to Delete from data ");
		 }
		 cr.deleteById(cinemaId);
		 logger.info("Data Deleted succesfully");
		 return "Removed cinema Successfully "+cinemaId;
	 }
	 public cinemaHall update(cinemaHall cinema) {
		 cinemaHall exixtCinemas=cr.findById(cinema.getId()).orElse(null);
		 if(exixtCinemas==null) {
			 throw new CustomException("Given the cinema details of saved data to modify");
		 }
		 exixtCinemas.setLocation(cinema.getLocation());
		 exixtCinemas.setName(cinema.getName());
		 exixtCinemas.setT1(cinema.getT1());
		 exixtCinemas.setT2(cinema.getT2());
		 exixtCinemas.setT3(cinema.getT3());
		 exixtCinemas.setT4(cinema.getT4());
		 exixtCinemas.setT5(cinema.getT5());
		 return cr.save(exixtCinemas);
	 }
	 public List<cinemaHall> getCinemaByid(String moviename,LocalDate d) {
		 
		 if(cr.findByMovieName(moviename,d).isEmpty()) {
			 logger.warn("No Data retrived for given data");
				throw new CustomException("Given cinema id is not there");
		 }
		 return cr.findByMovieName(moviename,d);
	 }

}
