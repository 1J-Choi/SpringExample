package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity studentEntity);
	// public Optional<StudentEntity> findById(int id);
	// Optional: null인지 아닌지 체크하는 객체
	// public void delete(StudentEntity studentEntity);
	
	// 조회
	// public List<StudentEntity> findAll();
	// findAll 뒤에 By 빼먹지 말기!
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	// 매개변수의 이름은 상관 X
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int id1, int id2);
}
