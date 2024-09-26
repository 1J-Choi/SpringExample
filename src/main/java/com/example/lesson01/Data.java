package com.example.lesson01;

// 일반 java bean으로 사용
public class Data {
	// field
	private int id;
	private String name;
	
	// method (우클릭>source를 통해 자동으로 getter setter 만들기 가능)
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
}
