package com.qa.movies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movies.domain.Movies;
import com.qa.movies.service.MoviesServiceDB;

@RestController
public class MoviesController {

	private MoviesServiceDB service;
	
	public MoviesController(MoviesServiceDB service) {
		this.service = service; 
	}
		
	// CRUD 
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Movies> createEntry(@RequestBody Movies movies) {
		return new ResponseEntity<Movies>(this.service.create(movies),HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Movies>> getMovies(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	
	// DELETE
	@DeleteMapping("/remove/{index}")
	public boolean removeEntry(@PathVariable Long index) {
		return this.service.remove(index);
		
	}
	
	// UPDATE
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movies> updateEntry(@PathVariable Long id, @RequestBody Movies newObject){
		return new ResponseEntity<Movies>(this.service.update(id, newObject), HttpStatus.ACCEPTED);
} 
}
