package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElderlyCareManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElderlyCareManagementSystemApplication.class, args);
		System.out.println("Started ...");
	}

	@Bean
	public ModelMapper configureMapper() {
		System.out.println("In Config Mapper....");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
