package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson06/ex01")
public class Lesson06Ex01Controller {
	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUser() {
		return "lesson06/addUser1";
	}
	
	// 회원가입 진행 => AJAX 요청
	// http://localhost/lesson06/ex01/after-add-user
	@ResponseBody
	@PostMapping("/after-add-user")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 응답값 => String
		return "성공";
	}
	
	// 가입 완료 화면
	// http://localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser1";
	}
}
