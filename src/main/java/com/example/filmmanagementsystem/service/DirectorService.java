package com.example.filmmanagementsystem.service;

import java.util.List;

import com.example.filmmanagementsystem.entities.Director;

public interface DirectorService {

	Director createDirector(Director director);

	Director updateDirector(Director director, Director director2);

	List<Director> getDirector(String movieName);

	List<Director> getAllDirectors();

	Director getParticularDirector(String directorName);

}
