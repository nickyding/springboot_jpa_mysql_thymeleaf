package com.springBoot.curdDemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.curdDemo.jpa.PersonRespository;
import com.springBoot.curdDemo.jpa.entity.Person;

@Service
public class PersonService {
	@Autowired
	PersonRespository personRespository;
	
	public void create(String name, String phone) {
		Person person = new Person();
		person.setName(name);
		person.setPhone(phone);
		personRespository.save(person);
	}
	
	public void update(Integer id, String name, String phone) {
		Person person = personRespository.findOne(id);
		person.setName(name);
		person.setPhone(phone);
		personRespository.save(person);
	}
	
	public List<Person> read() {
		List<Person> persons = new ArrayList<Person>();
		Iterator<Person> it = personRespository.findAll().iterator();
		while (it.hasNext()) {
			Person person = it.next();
			persons.add(person);
		}
		return persons;
	}
	
	public void delete(Integer id) {
		personRespository.delete(id);
	}
}















