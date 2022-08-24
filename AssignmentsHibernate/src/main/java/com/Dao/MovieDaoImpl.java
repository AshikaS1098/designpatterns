package com.Dao;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Operations.MovieOperations;
import com.model.Movie;


public class MovieDaoImpl implements MovieDao{

	private SessionFactory sessionFactory;
	private Session session;

	public MovieDaoImpl() {
		sessionFactory = MovieOperations.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public String addMovie(Movie movie) throws Exception {
		try {
			session.save(movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Data is not inserted");
		}
		return "Data inserted Successfully";
	}

	public void deleteMovie(String id) {
		Movie movie = getMovieDetails(id);
		if (!Objects.isNull(movie)) {
			session.remove(movie);
			session.getTransaction().commit();
		}
	}

	public void updateMovie(Movie movie) {
		session.update(movie);
		session.getTransaction().commit();
	}

	public Movie getMovieDetails(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	



}
