package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 어노테이션을 자동으로 읽으려면 @SpringBootApplication 이하의 폴더에 어노테이션을 배치한다.
@SpringBootApplication 
public class BootTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootTest1Application.class, args);
	}

}

