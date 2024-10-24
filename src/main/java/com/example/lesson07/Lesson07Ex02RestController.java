package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {
	// 해당 예제에서만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1. 전체 조회
		// return studentRepository.findAll();
		
		// 2. id 기준 내림차순 전체 조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3. id 기준 내림차순 3개행 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. 이름이 특정값인 데이터 조회
		// return studentRepository.findByName("한둘셋");
		
		// 5. in문으로 일치하는 이름값 모두 조회
		// List.of()로 바로 List 생성하여 대입
		// return studentRepository.findByNameIn(List.of("유재석", "조세호"));
		
		// 6. 여러 컬럼값과 일치하는 데이터 조회 (name, dreamJob)
		// return studentRepository.findByNameAndDreamJob("유재석", "래퍼");
		
		// 7. email에 "naver" 포함된 데이터 조회 - like문 %naver%
		// sql의 like = Contains, sql의 = = Like
		// return studentRepository.findByEmailContains("naver");
		
		// 8. 이름이 "한"으로 시작하는 데이터로 조회 - like문 한%
		// StartingWith
		// return studentRepository.findByNameStartingWith("한");
		
		// 9. id의 구간이 2~3까지인 데이터 조회 - between id 2 and 6
		return studentRepository.findByIdBetween(2, 3);
	}
}
