package com.movie.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Movie;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class MovieControler {

	@Autowired
	MovieService mService;
	
	@PostMapping("/movie/add")
	public boolean insert(@RequestBody Movie movie) {
		return  mService.insert(movie);
	}
	@PostMapping("/movie/update")
	public boolean updateMovie(@RequestBody Movie movie) {
		return mService.updateMovie(movie);
	}
	@GetMapping("/movie/getAll")
	public List<Movie> getAllMovies(){
		return mService.getAllMovies();
	}
	@GetMapping("/movie/getsearch/{search}")
	public List<Movie> getAllMoviesByCategory(@PathVariable String search){
		return mService.getAllMoviesByCategory(search);
	}
    @GetMapping("/movie/getByLanguage/{lang}")
	public List<Movie> getAllMoviesByLanguage(@PathVariable String lang){
		return mService.getAllMoviesByLanguage(lang);
	}
    @GetMapping("/movie/getByStatus/{stat}")
	public List<Movie> getAllMoviesByStatus(@PathVariable String stat){
		return mService.getAllMoviesByStatus(stat);
	}
    @GetMapping("/movie/getByTitle/{title}")
	public List<Movie> getAllMoviesByTitle(@PathVariable String title){
    	return mService.getAllMoviesByTitle(title);
	}
    @GetMapping("/movie/getById/{id}")
	public Movie getMoviesById(@PathVariable Long id){
		return mService.getMoviesById(id);
		}
    @GetMapping("/movie/getByemail/{email}")
	public List<Movie> getMoviesById(@PathVariable String email){
    	System.out.println("okkk");
		return mService.getMoviesByemail(email);
	}
    @GetMapping("/movie/getByemailName/{email}/{mname}")
	public Movie getMoviesByNameEmail(@PathVariable String email,@PathVariable String mname) {
    	System.out.println("okkk");
		return mService.getMoviesByNameEmail(email,mname);
	}
    @DeleteMapping("/movie/del/{mname}/{email}")
    public int deleteByNameEmail(@PathVariable String mname,@PathVariable String email) {
    	System.out.println("del done");
    	return mService.deleteByNameEmail(mname,email);
    }
    @GetMapping("/movie/del/{movieId}")
	public boolean deleteMovie(@PathVariable long movieId) {
    	return mService.deleteMovie(movieId);
    }
}
