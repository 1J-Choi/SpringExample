package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 - id로 entity 조회
		// orElse(null) null이 아니면 Optional내의 객체 줌
		// null이면 ()안의 객체 null 줌
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// update -> save() - insert, update(pk가 있을 때)
		if(student != null) {
			// 조회된 데이터가 있을 때 업데이트 진행
			// 변경할 내용을 Entity에 세팅 후 save(id 존재) => update
			student = studentRepository.save(student.toBuilder()
					.dreamJob(dreamJob)
					.build());
		}
		return student;
	}
	
	public void deleteStudentById(int id) {
		// 1. 삭제할 대상 select => 삭제
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		// 2. 삭제할 대상 select => Optional 활용 삭제
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		// Optional 내의 StudentEntity를 ifPresent()를 통해 s로 지정
		// 이후 람다식으로 delete(s) 호출
		studentOptional.ifPresent(s -> studentRepository.delete(s));

	}
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
