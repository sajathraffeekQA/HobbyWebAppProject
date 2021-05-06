package com.qa.movies.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.movies.domain.Movies;
import com.qa.movies.repo.MoviesRepo;


	@Service
	public class MoviesServiceDB {
		
		private MoviesRepo repo;
		
		public MoviesServiceDB(MoviesRepo repo) {
			this.repo = repo; 
		}
		
	
		public Movies create(Movies m) {
			return this.repo.save(m);
//			return this.repo.saveAndFlush(m);
		}

		
		public List<Movies> getAll() {
			return this.repo.findAll();
		}



		public boolean remove(Long id) {
			this.repo.deleteById(id);
			return this.repo.existsById(id);
		}

		
		public Movies update(Long id, Movies newMovies) {
			Movies entry = this.repo.findById(id).orElseThrow(); 
			
			entry.setMovieTitle(newMovies.getMovieTitle());
			entry.setReleaseYear(newMovies.getReleaseYear());
			entry.setRating(newMovies.getRating());
			entry.setGenre(newMovies.getGenre());
			
			return this.repo.saveAndFlush(entry);
		
		}
	
		public Movies getById(Long id) {
			Optional<Movies> optionalEntry = this.repo.findById(id);
			return optionalEntry.get(); 
		

}
}