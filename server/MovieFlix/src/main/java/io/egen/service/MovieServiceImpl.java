package io.egen.service;

import java.util.List;
import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExistsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl  implements MovieService
{
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) throws MovieNotFoundException 
	{
		Movie movie = repository.findOne(id);
		if(movie == null) 
		{
			throw new MovieNotFoundException();
		}
		else  
		{
			return movie;
		}
	}

	@Override
	public Movie findByTitle(String title) throws MovieNotFoundException 
	{
		Movie existing = repository.findByTitle(title);
		if(existing==null) 
		{
			throw new MovieNotFoundException();
		}
		else 
		{
			return existing;
		}
	}

	@Override
	public List<Movie> findByType(String type) throws MovieNotFoundException 
	{
		List<Movie> movie = repository.findByType(type);
		if(movie.isEmpty()) 
		{
			throw new MovieNotFoundException();
		}
		else
		{
			return movie;
		}
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExistsException 
	{
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null) 
		{
			throw new MovieAlreadyExistsException();
		}
		else 
		{
			return repository.create(movie);
		}
	}

	@Override
	public Movie update(String id, Movie movie) throws MovieNotFoundException
	{
		Movie existing = repository.findOne(id);
		if(existing == null) 
		{
			throw new MovieNotFoundException();
		}
		else 
		{
			return repository.update(movie);
		}
	}

	@Override
	public void delete(String id) 
	{
		Movie existing = repository.findOne(id);
		if(existing != null) 
		{
			repository.delete(existing);
		}
	}
	
	@Override
	public List<Movie> sortByYear() 
	{
		return repository.sortByYear();
	}

	@Override
	public List<Movie> sortByIMDBRating() 
	{
		return repository.sortByIMDBRating();
	}

	@Override
	public List<Movie> sortByIMDBVotes() 
	{
		return repository.sortByIMDBVotes();
	}
	
	@Override
	public List<Movie> getTopMovies() 
	{
		return repository.getTopMovies();
	}
}