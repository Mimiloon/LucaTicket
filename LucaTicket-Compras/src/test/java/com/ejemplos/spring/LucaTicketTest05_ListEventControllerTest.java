//package com.ejemplos.spring;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.ejemplos.spring.controller.EventController;
//import com.ejemplos.spring.model.Event;
//import com.ejemplos.spring.repository.EventRepository;
//import com.ejemplos.spring.service.EventServiceImpl;
//
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//class LucaTicketTest11_addEventControllerTest {
//	
//
//	@MockBean
//	EventServiceImpl serv;
//	
//	@Autowired
//	EventController control;
//	
//	@MockBean
//	EventRepository repo;
//	
//	
//	Event e1 = new Event();
//
//	{
//	String id = "1111";
//	String name = "Evento1";
//	String shortDescription ="Music";
//	String longDescription ="Music Event";
//	String image ="image";
//	@SuppressWarnings("deprecation")
//	Date date = new Date("2022/02/01");
//	String hour = "12:30:00";
//	int minimumprice = 3;
//	int maximumprice = 15;
//	String access = "sin condiciones";
//	String locationname = "locationname";
//	String locationcity = "locationcity";
//	String locationaddress = "locationaddress";
//	int locationcapacity = 15000;
//	String genre = "Country";
//
//	e1.setId(id);
//	e1.setName(name);
//	e1.setShortDescription(shortDescription);
//	e1.setLongDescription(longDescription);
//	e1.setImage(image);
//	e1.setDate(date);
//	e1.setHour(hour);
//	e1.setMaximumprice(minimumprice);
//	e1.setMinimumprice(maximumprice);
//	e1.setAccess(access);
//	e1.setLocationname(locationname);
//	e1.setLocationcity(locationcity);
//	e1.setLocationaddress(locationaddress);
//	e1.setLocationcapacity(locationcapacity);
//	e1.setGenre(genre);
//	}
//	
//   @BeforeEach
//   public void setUp() throws Exception{
//        MockitoAnnotations.initMocks(this);   
//   }
//   
//   @Test
//   public void listAllEventTest() throws Exception { 	
//		List<Event> eventList = repo.findAll();
//		when(serv.findAll()).thenReturn(eventList);
//		assertThat(control.readEvents().contains(e1));
//		verify(serv, times(1)).findAll();
//		verifyNoMoreInteractions(serv);
//    }
//	
//
//}
