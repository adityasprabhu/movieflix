package io.egen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.entity.Review;
import io.egen.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService
{
	@Autowired
	private ReviewRepository repository;
	
	@Override
	public List<Review> findById(String id) 
	{
		List<Review> reviews = repository.findById(id);
		if(reviews !=null) 
		{
			return reviews;
		}
		else
		{
			return null;		
		}
	}
	
	@Override
	public Review findOne(String id) 
	{
		Review review = repository.findOne(id);
		if(review == null) 
		{
			return null;
		}
		else  
		{
			return review;
		}
	}

	@Override
	public Review create(Review review) 
	{
			return repository.create(review);
	}
	
	@Override
	public Review update(String id, Review review)
	{
		Review existing = repository.findOne(id);
		if(existing == null) 
		{
			return null;
		}
		else 
		{
			return repository.update(id, review);
		}
	}

	@Override
	public void delete(Review review)
	{
		repository.delete(review);
	}
}