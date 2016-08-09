package com.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7649449670712991234L;
	public String name;
	public Integer Id;
	
	
	public User(String name, Integer id) {
		super();
		this.name = name;
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	
	
}
