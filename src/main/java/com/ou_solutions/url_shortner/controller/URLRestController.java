package com.ou_solutions.url_shortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ou_solutions.url_shortner.dto.URLDto;
import com.ou_solutions.url_shortner.dto.URLShortner;
import com.ou_solutions.url_shortner.service.URLService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class URLRestController {
	
	private final URLService service;

	@PostMapping("/create-url")
	public ResponseEntity<URLDto> createShortURL(@RequestBody URLShortner url)
	{
		 this.service.createShortURL(url); 
		 
		 return null;
	}
	
}
