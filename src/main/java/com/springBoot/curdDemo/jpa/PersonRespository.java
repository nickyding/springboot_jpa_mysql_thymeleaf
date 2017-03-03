package com.springBoot.curdDemo.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springBoot.curdDemo.jpa.entity.Person;

public interface PersonRespository extends PagingAndSortingRepository<Person, Integer> {
	
}
