package com.qa.movies.service;

import java.util.List;

import com.qa.movies.domain.Movies;

public interface MoviesService {

	Movies create(Movies m); 
	List<Movies> getAll(); 
	Movies getById(Long id);
	boolean remove(Long id); 
	Movies update(Long id, Movies newMovies);
}
