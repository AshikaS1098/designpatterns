package com.hibernate;

import java.util.Objects;

import com.Dao.MovieDao;
import com.Dao.MovieDaoImpl;
import com.model.Movie;


public class App 
{
	private static MovieDao moviedao = new MovieDaoImpl();

	public static void main(String[] args) throws Exception {
	
		delete();
	}

	private static void delete() {
		moviedao.deleteMovie("MOVIE-100");
	}

	private static void update() {
		Movie movie =moviedao.getMovieDetails("MOVIE-100");
		if(!Objects.isNull(movie)) {
		
			//getRevenueInDollars()+100
			movie.setRevenueInDollars(movie.getRevenueInDollars()+100);
			moviedao.updateMovie(movie);
			System.out.println("Data updated successfully");
		}else System.out.println("Data is not updated");
		
	}

	private static void read() {
		Movie movie = moviedao.getMovieDetails("MOVIE-001");
		System.out.println("\n"+movie);
	}

	private static void insert() throws Exception {
		Movie movie = new Movie("MOVIE-100", "heir", "English", 2022, 5000);
		System.out.println(moviedao.addMovie(movie));
	}

}
