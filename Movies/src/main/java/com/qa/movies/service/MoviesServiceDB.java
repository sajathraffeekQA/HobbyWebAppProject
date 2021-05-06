package com.qa.movies.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.movies.domain.Movies;


	@Service
	public class MoviesServiceDB implements MoviesService{
		
		private MoviesRepo repo; // <-- dependency
		
		public MoviesServiceDB(MoviesRepo repo) {
			this.repo = repo; 
		}
		
		@Override
		public Movies create(Movies m) {
			return this.repo.save(m);
//			return this.repo.saveAndFlush(m);
		}

		@Override
		public List<Movies> getAll() {
			return this.repo.findAll();
		}


		@Override
		public boolean remove(Long id) {
			this.repo.deleteById(id);
			return this.repo.existsById(id);
		}

		@Override
		public Movies update(Long id, Movies newMovies) {
			Movies entry = this.repo.findById(id).orElseThrow(); 
			
			entry.setMovieTitle(newMovies.getMovieTitle());
			entry.setReleaseYear(newMovies.getReleaseYear());
			entry.setRating(newMovies.getRating());
			entry.setGenre(newMovies.getGenre());
			
			return this.repo.saveAndFlush(entry);
		}

		

}
