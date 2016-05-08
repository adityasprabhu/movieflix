package io.egen.controller;

import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistsException;
import io.egen.exception.UserNotFoundException;
import io.egen.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController
{
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll () 
	{
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String userId) throws UserNotFoundException 
	{
		return service.findOne(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create (@RequestBody User user) throws UserAlreadyExistsException 
	{
		return service.create(user);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update (@PathVariable("id") String id, @RequestBody User user) throws UserNotFoundException 
	{
		return service.update(id, user);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete (@PathVariable("id") String id) throws UserNotFoundException 
	{
		service.delete(id);
	}
}
