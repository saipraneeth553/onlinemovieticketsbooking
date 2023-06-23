package com.movie.controler;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.seats;
import com.movie.service.SeatsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class SeatsControler {

	@Autowired
	SeatsService sService;
	@PostMapping("/seat/add")
    public boolean insert(@RequestBody seats seat) {
    	return sService.insert(seat);
    }
	@GetMapping("/seat/getBtId/{m}/{t}/{st}")
	public List<Long> getSeatById(@PathVariable String m,@PathVariable String t,@PathVariable  @DateTimeFormat(pattern = "HH:mm:ss")  LocalTime st) {
		return sService.getSeatBymts(m,t,st);
	}
}
