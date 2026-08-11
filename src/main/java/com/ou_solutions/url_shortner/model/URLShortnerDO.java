package com.ou_solutions.url_shortner.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "url_shortner")
@Getter
@Setter
public class URLShortnerDO extends BaseDO {
	
	private String originalURL;
	private String shortURL;
	
	
	
	
}
