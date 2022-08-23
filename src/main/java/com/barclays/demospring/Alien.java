package com.barclays.demospring;

import org.springframework.stereotype.Component;

@Component
public class Alien {
	String Aname;
	int Age;
	
	public Alien() {
		super();
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public void show() {
		System.out.println("this is in Alien show ");
	}
}
