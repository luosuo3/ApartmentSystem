package com.apartment.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apartment.management.mapper")
public class ApartmentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentManagementSystemApplication.class, args);
	}

}
