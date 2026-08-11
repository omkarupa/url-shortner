package com.ou_solutions.url_shortner.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class URLConfig {
	
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}

}
