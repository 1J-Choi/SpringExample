package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04ex02Controller {
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudent() {
		return "lesson04/addStudent";
	}
	
	// 학생 DB추가 -> 방금 가입한 학생 정보
	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student student, 
			// form 태그의 name과 field가 일치하면 세팅된다
			Model model) {
		// DB insert
		studentBO.addStudent(student);
		
		// DB select
		// 이미 student에 정보가 있지만 DB에 들어간 것을 확인하기 위해 다시 받는다
		Student latestStudent= studentBO.getStudentById(student.getId());
		
		// Model에 최근 가입한 학생 담기
		model.addAttribute("student", latestStudent);
		
		return "lesson04/afterAddStudent"; // view 경로
	}
}
