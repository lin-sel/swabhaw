package com.techlabs.movie;

public class Movie {
	private String title;
	private String genre;
	private int rating;
	
	public Movie() {
		this("Sahoo","Action",(int) 8.9);
	}
	
	public Movie(String title, String genre, int rating) {
		this.genre = genre;
		this.title = title;
		this.rating = rating;
	}
	
	public void playIt() {
		System.out.println("Title: "+title+" Playing Movies.............");
	}
}
