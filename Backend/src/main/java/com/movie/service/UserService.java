package com.movie.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.movie.Dto.userDto;
import com.movie.entity.Login;
import com.movie.entity.User;
import com.movie.exceptions.CustomException;
import com.movie.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	BCryptPasswordEncoder  Bcrypt= new BCryptPasswordEncoder();
    
	
	public boolean insert(userDto user) {
		String passwordString=Bcrypt.encode(user.getPassword());
		User user2=new User(user.getId(), user.getEmail(), passwordString,user.getName(),user.getRoleString());
        
		uRepository.save(user2);
		return true;
	}
	public List<User> getAllUser(){
		return uRepository.findAll();
	}
	public boolean deleteUser(String Email) {
		uRepository.deleteBYEmail(Email);
		return true;
	}
	public boolean update(userDto user2) {
		User user=new User(user2.getId(), user2.getEmail(), user2.getPassword(),user2.getName(), user2.getRoleString());

		User existUser=uRepository.findByEmail(user.getEmail());
		
		existUser.setEmail(user.getEmail());
		
		existUser.setName(user.getName());
		
		existUser.setPwd(user.getPwd());
		
		existUser.setRoleString(user.getRoleString());
		return true;
	}
	public User getUserByEmail(String userEmail) {
          User u=uRepository.findByEmail(userEmail);
          
          return u;
	}
	public boolean check(Login u) {
		User user=getUserByEmail(u.getUserEmail());
		if(user==null) {
			throw new CustomException("no such email Exist");
		}
		return BCrypt.checkpw(u.getPassword(),user.getPwd());
		
	}
	
	public boolean regcheck(String email) {
		User user=getUserByEmail(email);
		if(user==null) {
			return false;
		}
		return true;
	}
	
	
}
