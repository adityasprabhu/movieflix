package io.egen.service;

import java.util.List;
import org.springframework.stereotype.Component;
import io.egen.entity.Review;

@Component
public interface ReviewService
{
	public List<Review> findById(String id);
	public Review findOne(String id);
	public Review create(Review review) ;
	public Review update(String id, Review review);
	public void delete(Review review);
}