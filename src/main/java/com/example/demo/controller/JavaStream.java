package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class JavaStream {

	public static void main(String [] args) throws Exception {
		
	Person person1 = new Person(10,"ravi");
	Person person2 = new Person(20,"sachin");
	Person person3 = new Person(30,"sumit");
	Person person4 = new Person(40,"ravi");
	
	List<Person> personList = new ArrayList<Person>();
	personList.add(person1);
	personList.add(person2);
	personList.add(person3);
	personList.add(person4);
	
	Human human = new Human(1,personList);
	List<Human> humanList = new ArrayList();
	humanList.add(human);
	
/** filter function 
 * 
 */
	List<Person> filterList = personList.stream().filter(person -> person.getAge()> 20).collect(Collectors.toList());
		System.out.println("filter function applied , filtered list is " +filterList);
	
		/** map function 
	 * 
	 */	
		List<String> nameList = personList.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println("map function applied , map list is " +nameList);

		/** mapToInt function 
		 * 
		 */
		
		Integer aggregareAge = personList.stream().mapToInt(Person::getAge).sum();
		System.out.println("aggregate age is = " +aggregareAge);
		
		/** count function 
		 * 
		 */
		Long count = personList.stream().filter(person -> person.getAge()>20).count();
		System.out.println("count is = " +count);
		
		
		/** findFirst function 
		 * 
		 */
		Optional<Person> op = personList.stream().filter(person -> person.getAge()>20).findFirst();
		if(op.isPresent()) {
			System.out.println("findFirst result is " + op);
		}
		
		/** findAny function 
		 * 
		 */
		Optional<Person> opAny = personList.stream().filter(person -> person.getAge()>20).findAny();
		if(op.isPresent()) {
			System.out.println("findFirst result is " + op);
		}
		
		/** allMatch function 
		 * 
		 */
	   boolean isPresent  = personList.stream().allMatch(person -> person.getName().startsWith("r"));
			System.out.println("allMatch result is " + isPresent);
			
			
			/** anyMatch function 
			 * 
			 */
		   boolean anyPresent  = personList.stream().anyMatch(person -> person.getName().startsWith("r"));
				System.out.println("anyMatch result is " + anyPresent);		
		
	
	
	/** Optional with Exception 
	 * 
	 */
	Person person = personList.stream().filter(p -> p.getAge()>20).findAny().orElseThrow(() -> new Exception());
	
	/** Grouping 
	 * 
	 */
  Map<String, Integer> hm = personList.stream().collect(Collectors.groupingBy(Person::getName,Collectors.summingInt(Person::getAge)));
   System.out.println("grouping by attributes on the basis of name is =" +hm);
	
   /** flatmap
	 * 
	 * 
	 * 
	 */
	List<String> personName =humanList.stream().map(h -> h.getPersonList()).flatMap(pList -> pList.stream().map(p -> p.getName())).collect(Collectors.toList());
	   System.out.println("flatmap applied on humanList " +personName);

   
	}
	
	
}
