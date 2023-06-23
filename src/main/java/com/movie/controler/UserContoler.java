package com.movie.controler;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Dto.userDto;
import com.movie.entity.Login;
import com.movie.entity.User;
import com.movie.exceptions.CustomException;

import com.movie.service.UserService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api")
public class UserContoler {
	@Autowired
	UserService uService;
	
	Logger logger=LoggerFactory.getLogger(UserContoler.class);
	
	@PostMapping("/user/add")
	public boolean insert(@RequestBody userDto user) {
		return uService.insert(user);
	}
	@PutMapping("/user/update")
	public boolean update(@RequestBody userDto user) {
		 
			return uService.update(user);
	
	}
	@PostMapping("/user/check")
	public boolean check(@RequestBody Login  l) {
			return uService.check(l);
	
	}
	@GetMapping("/userregcheck/{email}")
	public boolean regcheck(@PathVariable String email) {
		System.out.println(uService.regcheck(email));
		return uService.regcheck(email);
	}
    @GetMapping("/user/del/{userId}")
	public boolean deleteUser(@PathVariable String userId) {
		return uService.deleteUser(userId);
	}
    @GetMapping("/user/getById/{userId}")
	public userDto getUserById(@PathVariable String  userId) {
    	User user=uService.getUserByEmail(userId);
    	logger.info("error at getBy Id");
    	if(user==null) {
    		throw new CustomException("no such email Exist");
    	}
    	return etod(user);
    	
    }
    public userDto etod(User user) {
    	
    	userDto u=new userDto(user.getId(),user.getPwd(), user.getEmail(),user.getName(), user.getRoleString());
    	return u;
    			}
   

}
