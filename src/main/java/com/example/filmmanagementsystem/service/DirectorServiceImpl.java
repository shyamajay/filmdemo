package com.example.filmmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filmmanagementsystem.entities.Director;
import com.example.filmmanagementsystem.entities.Movie;
import com.example.filmmanagementsystem.repos.DirectorRepository;
import com.example.filmmanagementsystem.repos.MovieRepository;

@Service
public class DirectorServiceImpl implements DirectorService {


	@Autowired
	DirectorRepository repos;
	@Autowired
	MovieRepository repos1;
	
	public Director createDirector(Director director) {
		return repos.save(director);
	}
	
	public Director updateDirector(Director director, Director director2) {
		director2.setAge(director.getAge());
		director2.setAwardCount(director.getAwardCount());
		return repos.save(director2);
	}
	
	public List<Director> getDirector(String movieName){
		  Movie movie2 = repos1.findBymovieName(movieName);
		return movie2.getDirectors();
	}
	
	public List<Director> getAllDirectors(){
		return repos.findAll();
	}
	
	public Director getParticularDirector(String directorName) {
		return repos.findBydirectorName(directorName);
	}
}
