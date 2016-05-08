package io.egen.repository;

import java.util.List;
import io.egen.entity.Movie;

public interface MovieRepository 
{
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie findByTitle (String title);
	public List<Movie> findByType(String type);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	public List<Movie> sortByYear();
	public List<Movie> sortByIMDBRating();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> getTopMovies();
}
