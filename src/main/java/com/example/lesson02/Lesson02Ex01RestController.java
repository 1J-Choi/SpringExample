package com.example.lesson02;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson02Ex01RestController {
	// http://localhost/lesson02/ex1
	@RequestMapping("/lesson02/ex1")
	public List<UsedGoods> ex01() {
		List<UsedGoods> list = new ArrayList<>();
		
		return list;
	}
}
