package com.ou_solutions.url_shortner.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ou_solutions.url_shortner.dto.URLDto;
import com.ou_solutions.url_shortner.dto.URLShortner;
import com.ou_solutions.url_shortner.model.URLShortnerDO;
import com.ou_solutions.url_shortner.repository.URLRepo;
import com.ou_solutions.url_shortner.util.Base62Encoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class URLService {
	
	private final URLRepo repo;
	
	private final ModelMapper mapper;

	public URLDto createShortURL(URLShortner url) {
		
		Optional<URLShortnerDO> urlOptional = this.repo.findByOriginalURL(url.getOriginalURL());
		
		Optional<URLShortnerDO> urlAliasOptional = this.repo.findByShortURL(url.getShortURL());
		
		if(!urlOptional.isPresent())
		{
			if(url.getShortURL() != null && !url.getShortURL().isEmpty()  && !url.getShortURL().isBlank())
			{
				if(!urlAliasOptional.isPresent())
				{
					URLShortnerDO savedURLDO = this.repo.save( this.mapper.map(url, URLShortnerDO.class));
					
					return this.mapper.map(savedURLDO, URLDto.class);
					
				}
				
				throw new RuntimeException("Alias already exists");	
			}
			else {
				URLShortnerDO savedURLDO = repo.save( mapper.map(url, URLShortnerDO.class));
				
				 savedURLDO.setShortURL(Base62Encoder.encode(savedURLDO.getId()));
				 
				 savedURLDO = this.repo.save(savedURLDO);
				 
				return mapper.map(savedURLDO, URLDto.class);
			}
			
				
		}
		
		
		throw new RuntimeException("URL already has shortned URL");		
	}

	
	
	
}
