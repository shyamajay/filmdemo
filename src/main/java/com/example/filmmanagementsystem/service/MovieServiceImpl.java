package com.example.filmmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filmmanagementsystem.entities.Director;
import com.example.filmmanagementsystem.entities.Movie;
import com.example.filmmanagementsystem.repos.DirectorRepository;
import com.example.filmmanagementsystem.repos.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repos;
	@Autowired
	DirectorRepository repos1;
	
	public Movie createMovie(Movie movie,int id) {
		Director director = repos1.findById(id).get();
		List<Director> directors = new ArrayList<Director>();
		directors.add(director);
		List<Movie> movies = director.getMovies();
		movies.add(movie);
		director.setMovies(movies);
		movie.setDirectors(directors);
		return repos.save(movie);
	}


	public List<Movie> getMovies(String directorName) {
		List<Director>directors = repos1.findAll();
		for (Director director : directors) {
			if(director.getDirectorName().equals(directorName)) {
				return director.getMovies();
			}
		}
		return null;
	}
	
	public Movie updateMovie(Director director,String movieName) {
		Movie movie = repos.findBymovieName(movieName);
		List<Director> directors = movie.getDirectors();
		directors.add(director);
		Director director2 = repos1.findById(director.getId()).get();
		movie.setDirectors(directors);
		List<Movie> movies = director2.getMovies();
		movies.add(movie);
		return repos.save(movie);
	}
	
	public List<Movie> getAllMovies(){
		return repos.findAll();
	}
	
	public void deleteMovies(String movieName) {
		List<Movie> movies = repos.findAll();
		for (Movie movie : movies) {
			if(movie.getMovieName().equals(movieName)) {
				repos.delete(movie);
			}
		}
		
	}
	
	public List<Director> getDirector(String movieName){
		Movie movie = repos.findBymovieName(movieName);
		return movie.getDirectors();
	}


	
	

}
