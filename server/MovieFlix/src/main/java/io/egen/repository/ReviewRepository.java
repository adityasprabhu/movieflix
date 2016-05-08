package io.egen.repository;

import java.util.List;
import io.egen.entity.Review;

public interface ReviewRepository 
{
	public List<Review> findById(String id);
	public Review findOne(String id);
	public Review create(Review review);
	public Review update(String id, Review review);
	public void delete(Review review);
}