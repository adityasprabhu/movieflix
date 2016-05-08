package io.egen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistsException;
import io.egen.exception.UserNotFoundException;
import io.egen.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public User findOne(String id) throws UserNotFoundException 
	{
		User user = repository.findOne(id);
		if(user == null) 
		{
			throw new UserNotFoundException();
		}
		else 
		{
			return user;
		}
	}

	@Override
	public User create(User user) throws UserAlreadyExistsException
	{
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null) 
		{
			throw new UserAlreadyExistsException();
		}
		else 
		{
			return repository.create(user);
		}

	}

	@Override
	public User update(String id, User user) throws UserNotFoundException 
	{
		User existing = repository.findOne(id);
		if(existing ==null) 
		{
			throw new UserNotFoundException();
		}
		else 
		{
			return repository.update(user);
		}
	}

	@Override
	public void delete(String id) throws UserNotFoundException 
	{
		User existing = repository.findOne(id);
		if(existing == null) 
		{
			throw new UserNotFoundException();
		}
		repository.delete(existing);
	}
}