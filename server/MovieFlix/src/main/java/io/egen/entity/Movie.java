package io.egen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries (
		@NamedQuery(name="Movie.findByTitle", query="Select m from Movie m where m.Title= :pTitle")
		)
public class Movie
{
	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String id;

	@Column(unique=true)
	private String Title;
	public String getTitle() {return Title;}
	//public void setTitle(String Title) {this.Title = Title;}

	private int Year;
	private String Rated;
	private String Genre;
	private String Director;

	@JsonFormat(pattern="dd MMM yyyy")
	private Date ReleaseDate;
	private String Runningtime;

	@Column(columnDefinition="VARCHAR(4000)")
	private String Actors;

	private String Writer;
	private String Language;
	private String Country;
	private String IMDBID;
	private double IMDBRating;
	private long IMDBVotes;
	private String Type;
}