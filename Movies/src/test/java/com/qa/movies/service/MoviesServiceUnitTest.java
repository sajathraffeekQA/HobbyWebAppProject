package com.qa.movies.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.movies.domain.Movies;
import com.qa.movies.repo.MoviesRepo;

@SpringBootTest
public class MoviesServiceUnitTest {

	@Autowired
	private MoviesServiceDB service;
	
	@MockBean
	private MoviesRepo repo;
	
	@Test
	void testCreate() {
		//given
		Movies batman = new Movies("Batman", 2006, 90, "Action");
		Movies savedBatman = new Movies(2L,"Batman", 2006, 90, "Action");
		//when
		Mockito.when(this.repo.save(batman)).thenReturn(savedBatman);
		//then
		assertThat(this.service.create(batman)).isEqualTo(savedBatman);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(batman);
	}
		
		@Test
		void TestRead() {
			//given
			Movies batman = new Movies(1L,"Batman", 2006, 90, "Action");			
			List<Movies> MovieList = new ArrayList<>();
			MovieList.add(batman);
			
			//when
			Mockito.when(this.repo.findAll()).thenReturn(MovieList);
			
			//then
			assertThat(this.service.getAll()).isEqualTo(MovieList);
			}
			
		@Test
		void TestDelete() {
			//given
			//boolean deleted = this.repo.existsById(1L);
			//when
			Mockito.when(this.repo.existsById(1L)).thenReturn(false);
			//then
			assertThat(this.service.remove(1L)).isEqualTo(false);			
		}
		
		@Test
		void TestUpdate() {
			//given
			Movies batman = new Movies("Batman", 2012, 80, "Action");
			Movies updatedBatman = new Movies(1L, "Batman", 2012, 80, "Action");
			//when
			Mockito.when(this.repo.saveAndFlush(batman)).thenReturn(updatedBatman);
			//then
			assertThat(this.service.update(1L, batman)).isEqualTo(updatedBatman);
			
			Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(batman);
		}
		
		
	}
	

