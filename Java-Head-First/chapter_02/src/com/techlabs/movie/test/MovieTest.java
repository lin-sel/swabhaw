package com.techlabs.movie.test;

import com.techlabs.movie.Movie;

public class MovieTest {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.playIt();
		Movie movie1 = new Movie("Iron man","SCI-FI",9);
		movie1.playIt();
	}

}
