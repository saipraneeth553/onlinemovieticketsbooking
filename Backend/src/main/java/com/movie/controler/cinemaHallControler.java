package com.movie.controler;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.cinemaHall;
import com.movie.service.CinemaService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/")
public class cinemaHallControler {

	@Autowired
	CinemaService cService;
	
	

	@PostMapping("/cinema/add")
	public boolean add(@RequestBody cinemaHall ch) {
		return cService.insert(ch);
	}

	@GetMapping("/cinema/getBymnane/{cinemaId}/{date}")
	public List<cinemaHall> getCinemaByid(@PathVariable String  cinemaId,@PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
		return cService.getCinemaByid(cinemaId,date);
		
	}
	@GetMapping("/cinema/del/{cinemaId}")
	public String deleteCinema(@PathVariable Long cinemaId) {
		return cService.deleteCinema(cinemaId);
	}
}
