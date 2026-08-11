package com.ou_solutions.url_shortner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou_solutions.url_shortner.model.URLShortnerDO;

public interface URLRepo extends JpaRepository<URLShortnerDO, Long> {

	Optional<URLShortnerDO> findByOriginalURL(String url);

	Optional<URLShortnerDO> findByShortURL(String shortURL);

}
