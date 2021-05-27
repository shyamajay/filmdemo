package com.example.filmmanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {

	@Column(unique = true)
	private String movieName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int collection;
	private int rating;
	@ManyToMany(mappedBy = "movies",targetEntity = Director.class,cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("movies")
	private List<Director> directors = new ArrayList<Director>();

	public Movie() {
		super();
	}

	public Movie(String movieName, int id, int collection, int rating, List<Director> directors) {
		super();
		this.movieName = movieName;
		this.id = id;
		this.collection = collection;
		this.rating = rating;
		this.directors = directors;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void assignDirector(Director director) {
		directors.add(director);
	}

}
