package com.example.filmmanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String directorName;
	private int age;
	private String gender;
	private int awardCount;
	@ManyToMany(targetEntity = Movie.class,cascade = CascadeType.PERSIST)
	@JoinTable(name = "movie_director", 
    joinColumns = { @JoinColumn(name = "movie_id ") }, 
    inverseJoinColumns = { @JoinColumn(name = "director_id") })
	@JsonIgnoreProperties("directors")
	List<Movie> movies = new ArrayList<Movie>();

	public Director() {
		super();
	}

	public Director(int id, String directorName, int age, String gender, int awardCount) {
		super();
		this.id = id;
		this.directorName = directorName;
		this.age = age;
		this.gender = gender;
		this.awardCount = awardCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAwardCount() {
		return awardCount;
	}

	public void setAwardCount(int awardCount) {
		this.awardCount = awardCount;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
