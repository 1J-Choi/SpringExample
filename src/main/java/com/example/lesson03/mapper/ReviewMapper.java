package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	// input: int
	// output: Review 단건 or 없으면 null
	public Review selectReviewById(int id);
	// input: Review
	// output: int(수행된 행의 갯수) => Mybatis가 성공된 행의 개수를 준다
	// output이 필요 없다면 void로 해도 상관 X
	public int insertReview(Review review);
	// input : 파라미터들
	// output : int(수행된 행의 갯수) => Mybatis가 성공된 행의 개수를 준다
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
}
