package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;



class demo1 implements Comparable<demo1> {
	Integer age;
	String name;

	demo1() {

	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public demo1(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "demo1 [age=" + age + ", name=" + name + "]";
	}

	
   public int compareTo(demo1 d) {
	   return d.age.compareTo(this.age);
   }

   

} 

enum java{
	
	JAVA("java",1),
	CAVA("cava",2);
	
	String name;
	Integer id;
	
	java(String name,Integer id){
		this.name=name;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
	
}

interface hello{
	
	default void getname() {
		System.out.println("name");
	}
	
	static int getdata() {
		return 10;
	}
	
	
}
public class java8 implements hello{

		public void getname() {
			System.out.println("sub name");
		}
	public static void main(String[] args){
	java8 j = new java8();
	j.getname();
	
	}
}