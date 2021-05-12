package com.qa.movies.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pages {

	@FindBy(id = "movietitle")
	private WebElement movieTitle;

	@FindBy(id = "year")
	private WebElement releaseYear;

	@FindBy(id = "genre")
	private WebElement genre;

	@FindBy(className = "btn btn-success")
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

	public WebElement getReleaseYear() {
		return releaseYear;
	}

	public WebElement getGenre() {
		return genre;
	}

}
