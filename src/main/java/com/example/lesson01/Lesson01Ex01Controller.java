package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01") // 클래스에 있는 패스를 먼저 읽어들인다.
@Controller // Spring bean으로 등록
public class Lesson01Ex01Controller {

	// http://localhost:8080/lesson01/ex01/1
	// String을 브라우저에 출력
	@RequestMapping("/1") // 클래스의 패스 뒤에 붙는다
	@ResponseBody // return하는 String을 ResponseBody에 담고 HTML 응답값이 된다.
	public String ex01_1() {
		return "<h2>문자열을 ResponseBody에 넣는 예제</h2>";
	}
	
	// http://localhost:8080/lesson01/ex01/2
	// @ResponseBody를 메소드의 return 형태 앞에 붙일 순 있으나 잘 안씀
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 40);
		map.put("딸기", 100);
		map.put("바나나", 10);
		map.put("망고", 1);
		// Map 리턴 => JSON String
		// jackson 라이브러리 때문
		return map; // {"사과"=40,...}
	}
}
