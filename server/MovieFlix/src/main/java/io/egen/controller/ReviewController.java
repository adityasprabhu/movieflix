package io.egen.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.entity.Review;
import io.egen.exception.UserNotFoundException;
import io.egen.service.ReviewService;

@RestController
@RequestMapping(value="/review")
public class ReviewController
{
	@Autowired
	private ReviewService service;
	
	@RequestMapping(value="/findById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findById(@PathVariable("id") String id) throws UserNotFoundException
	{
		return service.findById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review findOne(@PathVariable("id") String id) throws UserNotFoundException
	{
		return service.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@RequestBody Review review) 
	{
		return service.create(review);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review update(@PathVariable("id") String id, @RequestBody Review review) throws UserNotFoundException 
	{
		return service.update(id, review);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete( @PathVariable("id") Review review) 
	{
		service.delete(review);
	}
}