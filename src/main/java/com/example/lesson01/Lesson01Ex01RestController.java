package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController 사용해서 String 리턴</h3>";
	}
	
	
	@RequestMapping("/4")
	public Map<String, Object> ex01_4() {
		Map<String, Object> map = new HashMap<>();
		map.put("아이스크림", 40);
		map.put("빵", 100);
		map.put("우유", 10);
		return map;
	}
	
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // java bean
		data.setId(1);
		data.setName("최원제");
		
		return data; // object -> JOSN String
	}
	
	// ResponseEntity<>를 통해 status 코드 번호를 지정하여 보낼 수 있다.
	// 400대 서버 접근도 못함
	// 500대 서버 문제다!
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(2);
		data.setName("최원투");
		
		return new ResponseEntity<>(data, HttpStatus.CREATED);
	}
}
