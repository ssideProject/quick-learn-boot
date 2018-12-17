package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customers")
@Data //롬복을 사용하면 getter와 setter를 자동으로 만들어준다.
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자를 만든다.
@NoArgsConstructor // 인자를 받지않는 기본 생성자 생성 (JPA 조건이다 그러나 버전이 다른 지금은 없어도 상관없는듯)
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
