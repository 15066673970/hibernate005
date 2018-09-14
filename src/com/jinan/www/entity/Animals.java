package com.jinan.www.entity;

import java.io.Serializable;

public class Animals implements Serializable {
//	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String name;
	private Integer age;
	public Animals() {
		super();
	}
	public Animals( String name, Integer age) {
		super();
		
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Animals [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

}
