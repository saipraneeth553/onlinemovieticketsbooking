
package com.movie.onlineTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.movie.entity.BookingDetails;
import com.movie.repository.BookingRepository;
import com.movie.service.bookingDetailsService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class bookingTest {

	@Autowired
	bookingDetailsService bd;
	
	@MockBean
	BookingRepository br;
	
	@Test
	public void getall() {
		when(br.findAll()).thenReturn(Stream.of(new BookingDetails(2L,LocalDateTime.of(2023, 2, 6, 12, 2, 3),LocalTime.of(1, 30),54L, 65L,LocalDate.of(25,2,23),LocalTime.of(1, 30),"pushpa","success","5,35","sai@gmail")).collect(Collectors.toList()));
             assertEquals(1,bd.getAllBookingDeatails().size());
	}
	@Test
	public void getbyemail() {
		BookingDetails bbcBookingDetails=new BookingDetails(2L,LocalDateTime.of(2023, 2, 6, 12, 2, 3),LocalTime.of(1, 30),54L, 65L,LocalDate.of(25,2,23),LocalTime.of(1, 30),"pushpa","success","5,35","sai@gmail");
		List<BookingDetails>bookingDetails=new ArrayList<>();
		bookingDetails.add(bbcBookingDetails);
		when(br.getAllBookingByUser("email")).thenReturn(Stream.of(new BookingDetails(2L,LocalDateTime.of(2023, 2, 6, 12, 2, 3),LocalTime.of(1, 30),54L, 65L,LocalDate.of(25,2,23),LocalTime.of(1, 30),"pushpa","success","5,35","sai@gmail")).collect(Collectors.toList()));
		assertEquals(bookingDetails.size(),bd.getAllBookingByUser("email").size());
	}
	@Test
	public void insertbd() {
		BookingDetails bbcBookingDetails= new BookingDetails(2L,LocalDateTime.of(2023, 2, 6, 12, 2, 3),LocalTime.of(1, 30),54L, 65L,LocalDate.of(25,2,23),LocalTime.of(1, 30),"pushpa","success","5,35","sai@gmail");
        when(br.save(bbcBookingDetails)).thenReturn(bbcBookingDetails);
        assertTrue(bd.insert(bbcBookingDetails));
	}
	@Test
	public void delete() {
		BookingDetails bbcBookingDetails=new BookingDetails(2L,LocalDateTime.of(2023, 2, 6, 12, 2, 3),LocalTime.of(1, 30),54L, 65L,LocalDate.of(25,2,23),LocalTime.of(1, 30),"pushpa","success","5,35","sai@gmail");
		when(br.findById((long) 1)).thenReturn(Optional.of(bbcBookingDetails));
		bd.delete(1);
		verify(br,times(1)).deleteById((long) 1);
	}
	
}
