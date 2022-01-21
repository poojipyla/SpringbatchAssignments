package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
