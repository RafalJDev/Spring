package com.RJ.crud.proj.dao;

import java.util.List;

import com.RJ.crud.proj.entity.Person;

public interface PersonDAO {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

}
