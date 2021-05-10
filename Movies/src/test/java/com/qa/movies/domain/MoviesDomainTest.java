package com.qa.movies.domain;

import javax.persistence.Id;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;


public class MoviesDomainTest {

	@Test 
	public void testEqualsMovies() {
		EqualsVerifier.simple().forClass(Movies.class)
		.withIgnoredAnnotations(Id.class)	
		.verify();
}
}