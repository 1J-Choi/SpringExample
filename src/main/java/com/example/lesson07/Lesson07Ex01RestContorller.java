package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestContorller {
	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "곽두팔";
		String phoneNumber = "01099999999";
		String email = "guak@test.com";
		String dreamJob = "백수";
		
		// save 된 객체를 리턴하므로 id가 채워져있다!
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 4인 dreamJob을 건물주로 바꾼다
		return studentBO.updateStudentDreamJobById(4, "건물주");
	}
	
	// D: delete
	@GetMapping("/delete")
	public String delete() {
		// id 5번 삭제
		studentBO.deleteStudentById(5);
		return "삭제 완료";
	}
}
