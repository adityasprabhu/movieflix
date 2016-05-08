package io.egen.repository;

import java.util.List;
import io.egen.entity.Movie;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


@Repository
public class MovieRepositoryImpl  implements MovieRepository
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.Title ASC", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) 
	{
		return em.find(Movie.class, id);
	}

	@Override
	public Movie findByTitle(String title) 
	{
		TypedQuery<Movie> query= em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movie = query.getResultList();
		if(movie!= null && movie.size()==1) 
		{
			return movie.get(0);
		}
		else 
		{
			return null;
		}
	}

	@Override
	public List<Movie> findByType(String type) 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m where m.Type= :pType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public Movie create(Movie movie) 
	{
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) 
	{
		em.merge(movie);
		return movie;
	}

	@Override
	public void delete(Movie movie) 
	{
		em.remove(movie);
	}

	@Override
	public List<Movie> sortByYear() 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.Year DESC", Movie.class);
		List<Movie> movies = query.getResultList();
		if(movies.isEmpty()) 
		{
			System.out.println("No Movies Present.");
			return null;
		}
		else 
		{
			return query.getResultList();
		}
	}
	
	@Override
	public List<Movie> sortByIMDBRating() 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.IMDBRating DESC", Movie.class);
		List<Movie> movies = query.getResultList();
		if(movies.isEmpty()) 
		{
			System.out.println("No Movies Present.");
			return null;
		}
		else 
		{
			return query.getResultList();
		}
	}

	@Override
	public List<Movie> sortByIMDBVotes() 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.IMDBVotes DESC", Movie.class);
		List<Movie> movies = query.getResultList();
		if(movies.isEmpty()) 
		{
			System.out.println("No Movies Present.");
			return null;
		}
		else 
		{
			return query.getResultList();
		}
	}
	
	@Override
	public List<Movie> getTopMovies() 
	{
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m WHERE m.Type = :mType AND m.IMDBRating > :mValue", Movie.class);
		query.setParameter("mType", "movie");
		query.setParameter("mValue", 8.0);
		return query.getResultList();
	}
}