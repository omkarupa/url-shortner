package com.ou_solutions.url_shortner.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class URLDto {
	
	private String originalURL;
	private String shortURL;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	

}
