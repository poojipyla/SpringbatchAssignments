package com.batch.processor;

import com.batch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonProcessor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person person) throws Exception {
        log.info("Processing person with id: "+person.getId()+" and their details are: "+person);
        return person;
    }
}