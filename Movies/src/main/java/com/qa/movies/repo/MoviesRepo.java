package com.qa.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.movies.domain.Movies;


@Repository
public interface MoviesRepo extends JpaRepository<Movies, Long> {

}
