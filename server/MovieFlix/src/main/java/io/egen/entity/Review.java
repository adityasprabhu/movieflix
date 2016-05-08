package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Review 
{
	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String reviewId;
	
	@Column(columnDefinition="varchar(4000)")
	private String review;
	
	private String rating;
	
	@ManyToOne
	private Movie movie; 
	
	@ManyToOne
	private User user;
}