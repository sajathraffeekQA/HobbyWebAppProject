package com.qa.movies.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage {

	@FindBy(id = "movietitle")
	private WebElement movieTitle;

	@FindBy(id = "year")
	private WebElement releaseYear;

	@FindBy(id = "genre")
	private WebElement genre;
	
	@FindBy(id= "rating")
	private WebElement rating;
	
	@FindBy(id="clickhere")
	private WebElement clickhere;

	@FindBy(className = "btn-success")
	private WebElement submit;

	@FindBy(id = "onSuccess")
	private WebElement successmessage;

	public WebElement getSuccess() {
		return successmessage;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getMovieTitle() {
		return movieTitle;
	}
	

	public WebElement getClickhere() {
		return clickhere;
	}

	public void setClickhere(WebElement clickhere) {
		this.clickhere = clickhere;
	}

	public WebElement getReleaseYear() {
		return releaseYear;
	}
	
	

	public WebElement getRating() {
		return rating;
	}

	public void setRating(WebElement rating) {
		this.rating = rating;
	}

	public WebElement getGenre() {
		return genre;
	}

}
