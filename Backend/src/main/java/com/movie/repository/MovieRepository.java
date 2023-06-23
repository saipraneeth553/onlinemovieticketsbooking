package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;


@Component
@Repository
@EnableJpaRepositories
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "SELECT * FROM movie WHERE mov_id IN (SELECT MAX(mov_id) FROM movie GROUP BY mov_itle, mov_language) and mov_itle LIKE %?1%", nativeQuery = true)
	public List<Movie> getAllMoviesByCategory(String cat);
    @Query(value = "SELECT * FROM movie WHERE mov_id IN (SELECT MAX(mov_id) FROM movie GROUP BY mov_itle, mov_language) and mov_language =?1", nativeQuery = true)
	public List<Movie> getAllMoviesByLanguage(String lang);
    @Query("select m from Movie m where m.status=?1")
    public List<Movie> getAllMoviesByStatus(String stat);
    @Query("select m from Movie m where m.title=?1")
	public List<Movie> getAllMoviesByTitle(String title);
    @Query("select m from Movie m where m.email=?1")
	public List<Movie>getmovieByemail(String email);
    @Query(value = "SELECT * FROM movie WHERE mov_id IN (SELECT MAX(mov_id) FROM movie GROUP BY mov_itle, mov_language )order by mov_date desc", nativeQuery = true)
    public List<Movie> getAlld();
    
    @Modifying
    @Query("Delete from Movie m where m.email=?2 and m.title=?1")
     public int delByNameEmail(String mname, String email);
    
    @Query("select m from Movie m where m.email=?1 and m.title=?2")
	public Movie getMoviesByNameEmail(String email, String mname);

}

