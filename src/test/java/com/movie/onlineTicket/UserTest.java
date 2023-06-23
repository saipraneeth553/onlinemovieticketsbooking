package com.movie.onlineTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.Dto.userDto;
import com.movie.entity.User;
import com.movie.repository.UserRepository;
import com.movie.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {
	 @Autowired
	 UserService u;
	 @MockBean
	 UserRepository uR;
	 
	 @Test
	 public void insert() {
		 userDto user=new userDto(5,"Sai481481@gmail","sai553","praneeth","admin");
		 User user2=new User(user.getId(), user.getEmail(),user.getPassword(),user.getName(),user.getRoleString());
	        
	     when(uR.save(user2)).thenReturn(user2);
	     assertTrue(u.insert(user));
	 }
	 
	 @Test
	 public void getAlluser() {
		 User user=new User(5,"Sai481481@gmail","sai553","praneeth","admin");
		 User user1=new User(6,"Praneeth@gmail","sai553","sai praneeth","user");
		 User user2=new User(8,"Sai@gamail.com","sai553","praneeth","admin");
		 List<User>st=new ArrayList<>();
		 st.add(user);
		 st.add(user1);
		 st.add(user2);
		 when(uR.findAll()).thenReturn(st);
		 assertEquals(3, u.getAllUser().size());
	 }
	 
	 @Test
	 public void regcheck() {
		 User user=new User(5,"Sai481481@gmail","sai553","praneeth","admin");
		 when(uR.findByEmail("Sai481481@gmail")).thenReturn(user);
		 assertTrue(u.regcheck("Sai481481@gmail"));
		 
	 }
	 
	 

}
