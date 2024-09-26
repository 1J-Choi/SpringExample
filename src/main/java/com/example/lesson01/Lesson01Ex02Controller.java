package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 이동
@Controller // spring bean, html로 보낼 때는 @ResponseBody가 절대 있으면 안됨!
public class Lesson01Ex02Controller {
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// return 되는 String은 HTML의 경로
		// @ResponseBody가 없어야 한다!
		
		// /templates/lesson01/ex02.html
		// /templates/ 와 .html이 자동으로 생략된다!
		// 오류에 500이나 thymeleaf가 나오면 view의 경로 문제!
		return "lesson01/ex02";
	}
}
