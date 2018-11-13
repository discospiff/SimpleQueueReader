package com.plantplaces.photos.plantplacespostprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PlantplacespostprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantplacespostprocessorApplication.class, args);
	}
}
