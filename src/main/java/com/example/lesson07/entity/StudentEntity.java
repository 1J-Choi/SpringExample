package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // domain or entity 값을 찍었을 때 자세한 정보를 보여주게 한다
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자(기본 생성자)
@Builder // Setter 대용
@Getter
@Entity // 이 객체는 Entity이다. DB-JPA 통신
@Table(name = "new_student") // 테이블명, 지정 안하면 엔티티명이 테이블명으로 됨
public class StudentEntity {
	@Id // PK 식별자
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 id 가져옴
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // camelCase 인식하기 위함
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 값이 null이어도 insert 되는 시간으로 들어감
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // insert/update 때 시간으로
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
