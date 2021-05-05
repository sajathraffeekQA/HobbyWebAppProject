package com.qa.movies.domain;

public class Movies {

	private Long id;
	private String movieTitle;
	private int releaseYear;
	private int rating;
	private String genre;
	
	
	public Movies(Long id, String movieTitle, int releaseYear, int rating, String genre) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.genre = genre;
	}
		
	public Movies() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
}
