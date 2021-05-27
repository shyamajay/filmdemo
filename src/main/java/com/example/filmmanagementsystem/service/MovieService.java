package com.example.filmmanagementsystem.service;

import java.util.List;

import com.example.filmmanagementsystem.entities.Director;
import com.example.filmmanagementsystem.entities.Movie;

public interface MovieService {

	Movie createMovie(Movie movie, int id);

	List<Movie> getMovies(String directorName);

	Movie updateMovie(Director director, String movieName);

	List<Movie> getAllMovies();

	void deleteMovies(String movieName);

	List<Director> getDirector(String movieName);

}
