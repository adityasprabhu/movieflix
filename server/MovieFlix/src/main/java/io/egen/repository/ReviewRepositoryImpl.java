package io.egen.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.entity.Review;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Review> findById(String id)
	{
		TypedQuery<Review> query = em.createQuery("Select r from Review r where r.movie.id=:Id", Review.class);
		query.setParameter("Id", id);
		List<Review> reviews = query.getResultList();
		if(reviews!= null && reviews.size() >=1) 
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
		return em.find(Review.class, id);
	}

	@Override
	public Review create(Review review) 
	{

		em.persist(review);
		return review;
	}

	@Override
	public Review update(String id, Review review)
	{
		em.merge(review);
		return review;
	}
	
	@Override
	public void delete(Review review)
	{
		em.remove(review);
	}
}