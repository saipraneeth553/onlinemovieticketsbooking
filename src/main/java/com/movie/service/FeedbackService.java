package com.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Feedback;
import com.movie.exceptions.CustomException;
import com.movie.repository.FeedbackRepositary;

@Service
@Transactional
public class FeedbackService  {
	
	@Autowired
	FeedbackRepositary fRepositary;
	Logger logger=LoggerFactory.getLogger(CinemaService.class);

	

	public boolean insert(Feedback feed) {
		if(feed.getEmail().isEmpty()) {
			logger.error("error while adding feedback");
			throw new CustomException("fill Eamail details properly");
		}
		fRepositary.save(feed);
		
		logger.info("feedback added succesfully");
		return true;
		
	}
	public List<Feedback> getAllFeedbacks(){
		List<Feedback> f=new ArrayList<>();
		f=fRepositary.findAll();
		if(f.size()==0) {
			throw new NoSuchElementException("No e;lements Found");
		}
		return fRepositary.findAll();
	}
	
	public boolean deleteFeed(long feedId) {
		if(fRepositary.findById(feedId).isEmpty())
			throw new CustomException("no elements with given Id to delete");
		fRepositary.deleteById(feedId);
		return true;
	}
}
