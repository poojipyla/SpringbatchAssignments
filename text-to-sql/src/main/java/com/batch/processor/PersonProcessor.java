package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.model.Person;

public class PersonProcessor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person person) throws Exception {
        return person;
    }



}