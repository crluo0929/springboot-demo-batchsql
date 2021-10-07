package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Test {

//	@GenericGenerator(name = "gg", strategy = "identity")
//	@GeneratedValue	(strategy = GenerationType.AUTO,generator = "gg")
	@GeneratedValue	(strategy = GenerationType.AUTO)
	@Id 
	private int id ;
	private String name;
	private String address;
	
	public Test() {}
	
	public Test(int id,String name,String address) {
		this.id = id;
		this.name = name ;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
