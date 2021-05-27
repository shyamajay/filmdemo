package com.example.filmmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.filmmanagementsystem.entities.Director;
import com.example.filmmanagementsystem.entities.Movie;
import com.example.filmmanagementsystem.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	
	@Autowired
	MovieService movieservice;
	
	@PostMapping("{id}/movie/create")
	public Movie createMovie(@PathVariable("id")int id,@RequestBody Movie movie) {
		return movieservice.createMovie(movie,id);
	}
	
	@PatchMapping("/movie/update/{movieName}")
	public Movie updateMovie(@RequestBody Director director,@PathVariable("movieName") String movieName) {
		return movieservice.updateMovie(director,movieName);
	}
	
	@GetMapping("/movie/getDirector")
	public List<Director> getDirector(@RequestParam("movieName") String movieName){
		return movieservice.getDirector(movieName);
	}
	
	@GetMapping("/movie/getDirectors/{directorName}")
	public List<Movie>getMovies(@PathVariable ("directorName")String directorName){
		return movieservice.getMovies(directorName);
	}
	
	@GetMapping("/movie/getAll")
	public List<Movie>getAllMovies(){
		return movieservice.getAllMovies();
	}
	
	@DeleteMapping("/movie/delete/{movieName}")
	public void deleteMovies(@PathVariable("movieName") String movieName) {
		movieservice.deleteMovies(movieName);
	}
	


}
