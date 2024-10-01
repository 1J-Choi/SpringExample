package com.example.lesson03;

import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/lesson03/ex02")
public class Lesson03Ex02RestController {
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/1")
	public String ex01_1() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("혼밥왕");
		review.setPoint(4.5);
		review.setReview("고기가 냄새도 안나고 좋아요!");
		
		int rowCount = reviewBO.addReview(review);
		return "성공한 행의 갯수:" + rowCount;
	}
	
	@RequestMapping("/2")
	public String ex01_2() {
		int rowCount = reviewBO.addReviewAsField(
				4, "콤비네이션R", "마테오", 0.0, "이건 피자가 아니야!!!");
		return "성공한 행의 갯수:" + rowCount;
	}
	
}
