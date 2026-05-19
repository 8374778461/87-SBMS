package in.ashokit.beans;

import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;

import in.ashokit.records.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public @Nullable Person process(Person item) throws Exception {

		String fname = item.firstName().toUpperCase();
		String lname = item.lastName().toUpperCase();

		return new Person(fname, lname);

	}
}
