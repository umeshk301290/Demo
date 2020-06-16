package com.example.demo.controller;

import java.util.List;

class Human{
	
	Integer id;
	List<Person> personList;
	
	
	public Human(Integer id, List<Person> personList) {
		super();
		this.id = id;
		this.personList = personList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", personList=" + personList + "]";
	}
	
	
	
}

