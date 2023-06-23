package com.movie.onlineTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.entity.Feedback;
import com.movie.repository.FeedbackRepositary;
import com.movie.service.FeedbackService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class feedbackTest {
	
    @Autowired
    FeedbackService fService;
    
    @MockBean
    FeedbackRepositary fRepositary;
    
    @Test
    public void insert() {
    	Feedback feedback=new Feedback(5,"12-06-2023","sai@gmail","hai nice");
    	when(fRepositary.save(feedback)).thenReturn(feedback);
    	assertTrue(fService.insert(feedback));
    }
    @Test
    public void getAll(){
      when(fRepositary.findAll()).thenReturn(Stream.of(new Feedback(6,"12-06-2023","sai@gmail","hai nice"),new Feedback(7,"12-01-2023","sai481@gmail","hai nice"),new Feedback(8,"16-06-2023","sai@gmail","hai nice")).collect(Collectors.toList()));
      assertEquals(3, fService.getAllFeedbacks().size());
    }
    @Test
    public void delete() {
    	
    	Feedback feedback=new Feedback(5,"12-06-2023","sai@gmail","hai nice");
    	when(fRepositary.findById((long) 5)).thenReturn(Optional.of(feedback));
    	assertTrue(fService.deleteFeed(5));
    
    }
	
}
