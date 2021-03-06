package com.ejemplos.spring.service;


import java.util.Date;
import java.util.Iterator;
/**
 * 
* @author: Ana Díaz Muñoz, Rocío Jiménez, Rebeca Martínez, Sara Sevillano, Ana Ramírez*/
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.error.CityNotFoundException;
import com.ejemplos.spring.error.CustomException;
import com.ejemplos.spring.error.EventNotFoundException;
import com.ejemplos.spring.error.GenreNotFoundException;
import com.ejemplos.spring.error.IDAlreadyExists;
import com.ejemplos.spring.error.IDNotFoundException;
import com.ejemplos.spring.error.MaximumSizeException;
import com.ejemplos.spring.error.MinimumPriceException;
import com.ejemplos.spring.error.MinimumSizeException;
import com.ejemplos.spring.error.NameNotFoundException;
import com.ejemplos.spring.model.Event;

import com.ejemplos.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger LOG = LogManager.getLogger(EventServiceImpl.class);

	@Autowired
	private EventRepository repository;

	@Override
	public List<Event> findAll() {
		LOG.info("EVENT---->INTO findAll()");

		List<Event> result = repository.findAll();

		if (result.size() > 0) {
			LOG.info("OUT findAll(): {}", result);
			return repository.findAll();
		} else {
			LOG.info("Throwing exception...");
			throw new EventNotFoundException("List of Events is empty");
		}
	}

	@Override
	public Optional<Event> findById(String id) {
		Optional<Event> result = repository.findById(id);
		LOG.info("EVENT---->INTO findById()");
		if (result != null) {
			LOG.info("OUT findById(): {}", result);
			return result;
		} else {
			LOG.info("Throwing exception...");
			throw new EventNotFoundException("That id doesn't exist");
		}

	}
	
	@Override
	public Event save(Event event) {
		LOG.info("EVENT---->INTO save()");
		StringBuffer s = new StringBuffer();
		s.append("ok");
		List<Event> lst = repository.findAll();
		Iterator<Event> it = lst.iterator();
		while (it.hasNext()) {
			Event clave = it.next();
			if (clave.getId().equals(event.getId())) {
				LOG.info("Throwing exception...");
				throw new IDAlreadyExists("ID already exists.");
			}
		}
		if ((this.notNullAttributes(event).toString()).equals((s).toString())) {
			if (this.EventDateIsAfterActualDate(event)) {
				if ((this.maximumSize(event).toString()).equals((s).toString())) {
					if ((this.minimumSize(event).toString()).equals((s).toString())) {
						if((this.minimumPrice(event).toString()).equals((s).toString())) {
							return repository.save(event);
						} else {
							LOG.info("Throwing exception...");
							throw new MinimumPriceException(this.minimumPrice(event).toString());
						}
					} else {
						LOG.info("Throwing exception...");
						throw new MinimumSizeException(this.minimumSize(event).toString());
					}
				} else {
					LOG.info("Throwing exception...");
					throw new MaximumSizeException(this.maximumSize(event).toString());
				}
			} else {
				LOG.info("Throwing exception...");
				throw new CustomException("Event date has to be after actual date.");
			}
		} else {
			LOG.info("Throwing exception...");
			throw new CustomException(this.notNullAttributes(event).toString());
		}
	}         	

	@Override
	public void deleteById(String id) {
		LOG.info("EVENT---->INTO deleteById()");
		Optional<Event> result = repository.findById(id);
		if (result.isEmpty()) {
			LOG.info("Throwing exception...");
			throw new IDNotFoundException("ID not found");

		} else {
			LOG.info("OUT deleteById(): {}");
			repository.deleteById(id);
		}

	}

	@Override
	public List<Event> findByGenre(String genre) {
		LOG.info("EVENT---->INTO finByGenre()");
		List<Event> result = repository.findByGenre(genre);
		if (result.size() > 0) {
			LOG.info("OUT findByGenre(): {}");
			return repository.findByGenre(genre);
		} else {
			LOG.info("Throwing exception...");
			throw new GenreNotFoundException("There aren't events with this genre.");
		}

	}

	@Override
	public List<Event> findByCity(String city) {
		LOG.info("EVENT---->INTO finByCity()");
		List<Event> result = repository.findByLocationcity(city);
		if (result.size() > 0) {
			LOG.info("OUT findByCity(): {}");
			return repository.findByLocationcity(city);
		} else {
			LOG.info("Throwing exception...");
			throw new CityNotFoundException("There aren't events in that city.");
		}

	}

	@Override
	public List<Event> findByName(String name) {
		LOG.info("EVENT---->INTO finByName()");
		List<Event> result = repository.findByName(name);
		if (result.size() > 0) {
			LOG.info("OUT findByName(): {}");
			return repository.findByName(name);
		} else {
			LOG.info("Throwing exception...");
			throw new NameNotFoundException("Event with name " + name + " is not found");
		}
	}

	public StringBuffer notNullAttributes(Event e1) {
		StringBuffer sbf = new StringBuffer();
		StringBuffer sbf2 = new StringBuffer();
		int c = 0;
		sbf.append("Can not be empty: ");
		if (e1.getName() == null) {
			sbf.append("name, ");
			c++;
		} if (e1.getDate() == null) {
			sbf.append("date, ");
			c++;
		} if (e1.getHour() == null) {
			sbf.append("hour, ");
			c++;
		} if (e1.getLocationaddress() == null) {
			sbf.append("location address,");
			c++;
		} if (e1.getLocationcity() == null) {
			sbf.append("location city, ");
			c++;
		} if (e1.getLocationname() == null)
			sbf.append("location name,");

		if (c != 0) {
			return sbf;
		} else {
			sbf2.append("ok");
			return sbf2;
			
		}

	}

	public boolean EventDateIsAfterActualDate(Event e1) {
		Date d2 = new Date();
		if (e1.getDate().after(d2)) {
			return true;
		}
		return false;

	}

	public StringBuffer minimumSize(Event e1) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("ok");
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append("Error: ");
		int c = 0;
		int minS = 1;
		int minL = 8;
		int l1 = e1.getShortDescription().length();
		int l2 = e1.getLongDescription().length();
		if (l1 < minS) {
			sbf2.append("Short description too short");
			c++;
		} if (l2 < minL) {
			sbf2.append("Long Description too short");
			c++;
		} if ((l1 < minS) && (l2 < minL)) {
			sbf2.append("Both description are too short");
			c++;
		}	
		if (c != 0) {
			return sbf2;
		} else {
			return sbf;
			
		}
	}
	
	public StringBuffer minimumPrice(Event e1) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("ok");
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append("Error: ");
		int c = 0;
		int minP = 0;
		if (e1.getMinimumprice() < minP) {
			sbf2.append("Minimum price too low");
			c++;
		} if (e1.getMaximumprice()< minP) {
			sbf2.append("Maximum price too low");
			c++;
		}	
		
		if (c != 0) {
			return sbf2;
		} else {
			return sbf;	
		}
	}

	public StringBuffer maximumSize(Event e1) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("ok");
		StringBuffer sbf2 = new StringBuffer();
		sbf2.append("Error: ");
		int c = 0;
		int maxS = 50;
		int maxL = 2000;
		int l1 = e1.getShortDescription().length();
		int l2 = e1.getLongDescription().length();
		if (l1 > maxS) {
			sbf2.append("Short description too long");
			c++;
		} if (l2 > maxL) {
			sbf2.append("Long Description too long");
			c++;
		} if ((l1 > maxS) && (l2 > maxL)) {
			sbf2.append("Both description are too long");
			c++;
		}
		
		if (c != 0) {
			return sbf2;
		} else {
			return sbf;
		}
	}

}
