package com.movie.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Feedback;
import com.movie.service.FeedbackService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})


public class feedbackControler {
	@Autowired
	FeedbackService fService;
	
	@PostMapping("/feed/add")
	public boolean insert(@RequestBody Feedback feed) {
		return fService.insert(feed);
	}
	@GetMapping("/feed/getAll")
	public List<Feedback> getAllFeedbacks(){
		return fService.getAllFeedbacks();
	}
	@GetMapping("/feed/del/{feedId}")
	public boolean deleteFeed(@PathVariable Long feedId) {
		return fService.deleteFeed(feedId);
	}
	
	
    
}
