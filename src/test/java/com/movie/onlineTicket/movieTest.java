package com.movie.onlineTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class movieTest {
	
	@Autowired
	MovieService m;
	
	@MockBean
	MovieRepository mr;
	
	@Test
	public void getAll() {
	when(mr.getAlld()).thenReturn(Stream.of(new Movie(2l,"RadheaShyam",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","@sai481"),
			new Movie(3l,"pushapa2",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","not released","@sai481")).collect(Collectors.toList()));
	   assertEquals(2, m.getAllMovies().size());
	}
	
	@Test
	public void getAllByCategory() {
		when(mr.getAllMoviesByCategory("love")).thenReturn(Stream.of(new Movie(2l,"pudhpa",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","praneeth@553.com")).collect(Collectors.toList()));
		   assertEquals(1, m.getAllMoviesByCategory("love").size());
	}
	
	@Test
	public void insert() {
		Movie movie=new Movie(2l,"pudhpa",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","praneeth@553.com");

		when(mr.save(movie)).thenReturn(movie);
		assertTrue(m.insert(movie));
	}
	
	@Test
	public void getByTitle(){
		Movie movie=new Movie(2l,"pudhpa",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","praneeth@553.com");
        List<Movie> l=new ArrayList<>();
        l.add(movie);
        
		when(mr.getAllMoviesByTitle("pushpa")).thenReturn(Stream.of(new Movie(2l,"pudhpa",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","praneeth@553.com")).collect(Collectors.toList()));
	    assertEquals(l, m.getAllMoviesByTitle("pushpa"));
	}
    @Test
    public void delete() {
		Movie movie=new Movie(2l,"pudhpa",LocalDate.of(23, 2, 25),160,"love","telugu","aa,rashmika","https:pushpa/img","releasd","praneeth@553.com");

    	when(mr.findById((long) 3)).thenReturn(Optional.of(movie));
    	assertTrue(m.deleteMovie(3));
    	
    }
}
