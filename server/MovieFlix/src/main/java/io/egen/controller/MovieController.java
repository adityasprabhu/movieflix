package io.egen.controller;

import java.util.List;
import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExistsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movies")
public class MovieController 
{
	@Autowired
	private MovieService service;

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() 
	{
		return service.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String id)  throws MovieNotFoundException
	{
		return service.findOne(id);
	}

	@RequestMapping(value="/title/{Title}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("Title") String Title)  throws MovieNotFoundException
	{
		return service.findByTitle(Title);
	} 

	@RequestMapping(value="/type/{Type}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByType(@PathVariable("Type") String Type)  throws MovieNotFoundException
	{
		return service.findByType(Type);
	} 

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create( @RequestBody Movie movie) throws MovieAlreadyExistsException
	{
		return service.create(movie);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) throws MovieNotFoundException 
	{
		return service.update(id, movie);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id) 
	{
		service.delete(id);
	}
	
	@RequestMapping(value="/year", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear() 
	{
		return service.sortByYear();
	}

	@RequestMapping(value="/IMDBRating", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBRating()
	{
		return service.sortByIMDBRating();
	}

	@RequestMapping(value="/IMDBVotes", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBVotes() 
	{
		return service.sortByIMDBVotes();
	} 

	@RequestMapping(value="/topMovies", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getTopMovies() 
	{
		return service.getTopMovies();
	}
}