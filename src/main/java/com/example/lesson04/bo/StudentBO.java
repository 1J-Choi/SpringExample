package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA
	public StudentEntity addStudent(
			String name, String phoneNumber, 
			String email, String dreamJob) {
		// 객체 생성과 Setter를 한방에 가능!
		// 기존의 방식 중 오류 및 다른 작업으로 인해 생기는 문제 방지 가능
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				//.createdAt(LocalDateTime.now()) // @CreationTimestamp 있어서 생략 가능
				.build();
		
		return studentRepository.save(student);

	}
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
