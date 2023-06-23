package com.movie.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.exceptions.CustomException;
import com.movie.repository.MovieRepository;

@Service
@Transactional
@Component
public class MovieService  {
	
	@Autowired(required = true)
	MovieRepository mRepository;
	
	public boolean insert(Movie movie) {
		mRepository.save(movie);
		return true;
		
	}
	Logger logger=LoggerFactory.getLogger(MovieService.class);
	public List<Movie> getAllMovies(){
		List<Movie> m=mRepository.getAlld();
		if(m.size()==0) {
			logger.warn("No data Found at get All");
			throw new CustomException("No data found ");
		}
		return mRepository.getAlld();
	}
	
	public List<Movie> getAllMoviesByCategory(String cat)
	{
		List<Movie> m=mRepository.getAllMoviesByCategory(cat);
		if(m.size()==0) {
			throw new CustomException("No data found ");
		}
		logger.info("movies are retrived based on category");
		return mRepository.getAllMoviesByCategory(cat);
	}
	public List<Movie> getAllMoviesByLanguage(String lang){
		
		List<Movie> m=mRepository.getAllMoviesByLanguage(lang);
		if(m.size()==0) {
			throw new CustomException("No data found ");
		}
		return mRepository.getAllMoviesByLanguage(lang);
	}
	public List<Movie> getAllMoviesByStatus(String stat)
	{
		List<Movie> m=mRepository.getAllMoviesByStatus(stat);
		if(m.size()==0) {
			throw new CustomException("No data found ");
		}
	
		return mRepository.getAllMoviesByStatus(stat);
	}
	
	public List<Movie> getAllMoviesByTitle(String title){
		
		List<Movie> m=mRepository.getAllMoviesByTitle(title);
		if(m.size()==0) {
			throw new CustomException("No data found ");
		}
		return mRepository.getAllMoviesByTitle(title);
	}
	
	public Movie getMoviesById(Long id){
	    if(mRepository.findById(id).isEmpty())
	           throw new NoSuchElementException();
	    
	return mRepository.findById(id).orElse(null);
	}
	public boolean deleteMovie(long movieId) {
		if(mRepository.findById(movieId).isEmpty())
			throw new CustomException("no such element to dlete");
		mRepository.deleteById(movieId);
		return true;
	}
	public boolean updateMovie(Movie movie) {
		System.out.println(movie.getId());
		Movie existMovie=mRepository.findById(movie.getId()).orElse(null);
		if(existMovie==null) {
			throw new CustomException("please give a saved  Id to update");
		}
		existMovie.setCast(movie.getCast());
		existMovie.setCategory(movie.getCategory());
		existMovie.setDate(movie.getDate());
		
		existMovie.setImg(movie.getImg());
		existMovie.setLanguage(movie.getLanguage());
		existMovie.setLength(movie.getLength());
		existMovie.setStatus(movie.getStatus());
		existMovie.setTitle(movie.getTitle());
	    mRepository.save(existMovie);
	    return true;
	}

	public List<Movie> getMoviesByemail(String email) {
		// TODO Auto-generated method stub
		return mRepository.getmovieByemail(email);
		
	}

	public int deleteByNameEmail(String mname, String email) {
	
	 return mRepository.delByNameEmail(mname,email);
	}

	public Movie getMoviesByNameEmail(String email,String mname) {
	     
		return mRepository.getMoviesByNameEmail(email,mname);
	}
	
	

}
