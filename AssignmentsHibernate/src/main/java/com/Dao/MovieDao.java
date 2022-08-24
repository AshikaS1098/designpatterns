package com.Dao;

import com.model.Movie;

public interface MovieDao {
	String addMovie(Movie movie) throws Exception;

	void deleteMovie(String id);

	void updateMovie(Movie movie);

	Movie getMovieDetails(String string);


}
