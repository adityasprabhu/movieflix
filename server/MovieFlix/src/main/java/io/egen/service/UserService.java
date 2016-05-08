package io.egen.service;

import java.util.List;
import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistsException;
import io.egen.exception.UserNotFoundException;

public interface UserService 
{
	public List<User> findAll ();
	public User findOne (String id) throws UserNotFoundException;
	public User create (User user) throws UserAlreadyExistsException;
	public User update (String id, User user) throws UserNotFoundException;
	public void delete (String id) throws UserNotFoundException;
}