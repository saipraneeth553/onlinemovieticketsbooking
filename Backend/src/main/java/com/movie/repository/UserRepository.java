package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.movie.Dto.userDto;
import com.movie.entity.User;

@Component
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where email=?1")
	User findByEmail(String username);

	@Query("Delete from User where email=?1")
	void deleteBYEmail(String email);
	

}
