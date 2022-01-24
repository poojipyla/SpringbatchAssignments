package com.batch.processor;



import com.batch.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {
		return person;
	}
}