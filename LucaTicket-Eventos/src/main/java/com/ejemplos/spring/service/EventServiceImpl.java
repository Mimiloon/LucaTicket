package com.ejemplos.spring.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
* Class name: EventServiceImpl.java
* Date: 10/07/2021
* @version: 2.0
* @author: Ana Díaz Muñoz*/
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
		if (event.getId().isEmpty()) {
			// Si no está registrado comprueba que no tenga valores nulos
			if (this.notNullAttributes(event).equals(s)) {
				// Si no tiene valores nulos, comprueba que la fecha del evento es posterior a
				// la actual
				if (this.EventDateIsAfterActualDate(event)) {
					// Si la fecha es posterior a la actual comprueba que las descrpciones tienen el
					// tamaño adecuado
					if (this.maximumSize(event) == "ok") {
						if (this.minimumSize(event) == "ok") {
							return repository.save(event);
						} else {
							LOG.info("Throwing exception...");
							throw new MaximumSizeException(this.maximumSize(event));
						}
					} else {
						LOG.info("Throwing exception...");
						throw new MaximumSizeException(this.maximumSize(event));
					}

				} else {
					LOG.info("Throwing exception...");
					throw new CustomException("La fecha del evento debe ser posterior a la actual");
				}
			} else {
				LOG.info("Throwing exception...");
				throw new CustomException(this.notNullAttributes(event).toString());
			}
		} else {
			LOG.info("Throwing exception...");
			throw new IDAlreadyExists("El id ya existe");
		}
	}

	@Override
	public void deleteById(String id) {
		LOG.info("EVENT---->INTO deleteById()");
		Optional<Event> result = repository.findById(id);
		if (result.isEmpty()) {
			LOG.info("Throwing exception...");
			throw new IDNotFoundException("No se ha encontrado el id introducido");

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
			throw new GenreNotFoundException("No hay eventos de ese género");
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
			throw new CityNotFoundException("No hay eventos en esa ciudad");
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
			throw new NameNotFoundException("No hay eventos en esa ciudad");
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
		} else if (e1.getDate() == null) {
			sbf.append("date, ");
		} else if (e1.getHour() == null) {
			sbf.append("hour, ");
			c++;
		} else if (e1.getLocationaddress() == null) {
			sbf.append("location address,");
			c++;
		} else if (e1.getLocationcity() == null) {
			sbf.append("location city, ");
			c++;
		} else if (e1.getLocationname() == null)
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

	public String minimumSize(Event e1) {
		int minS = 1;
		int minL = 8;

		int l1 = e1.getShortDescription().length();
		int l2 = e1.getLongDescription().length();
		if (l1 < minS) {
			return "Short description too short";
		} else if (l2 < minL) {
			return "Long Description too short";
		} else if ((l1 < minS) && (l2 < minL)) {
			return "Both description are too short";
		}
		return "ok";
	}

	public String maximumSize(Event e1) {
		int maxS = 15;
		int maxL = 30;

		int l1 = e1.getShortDescription().length();
		int l2 = e1.getLongDescription().length();
		if (l1 > maxS) {
			return "Short description too long";
		} else if (l2 > maxL) {
			return "Long Description too long";
		} else if ((l1 > maxS) && (l2 > maxL)) {
			return "Both description are too long";
		}
		return "ok";
	}

}
