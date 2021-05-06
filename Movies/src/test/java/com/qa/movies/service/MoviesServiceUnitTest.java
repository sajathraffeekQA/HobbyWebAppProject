package com.qa.movies.service;

import static org.assertj.core.api.Assertions.assertThat;

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
		Movies batman = new Movies("Batman", 2006, 90, "Action");
		Movies savedBatman = new Movies(2L,"Batman", 2006, 90, "Action");
		
		Mockito.when(this.repo.save(batman)).thenReturn(savedBatman);
		
		assertThat(this.service.create(batman)).isEqualTo(savedBatman);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(batman);
		
		
		
		
	}
	
}
