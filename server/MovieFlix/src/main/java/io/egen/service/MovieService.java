package io.egen.service;

import java.util.List;
import org.springframework.stereotype.Component;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExistsException;
import io.egen.exception.MovieNotFoundException;
@Component
public interface MovieService
{
	public List<Movie> findAll();
	public Movie findOne(String id) throws MovieNotFoundException;
	public Movie findByTitle(String title) throws MovieNotFoundException;
	public List<Movie> findByType(String type) throws MovieNotFoundException;
	public Movie create(Movie movie) throws MovieAlreadyExistsException;
	public Movie update(String id,Movie movie) throws MovieNotFoundException;
	public void delete(String id);
	public List<Movie> sortByYear();
	public List<Movie> sortByIMDBRating();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> getTopMovies();
}
