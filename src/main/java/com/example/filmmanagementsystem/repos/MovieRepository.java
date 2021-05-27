package com.example.filmmanagementsystem.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filmmanagementsystem.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findBymovieName(String movieName);


}
