package com.example.filmmanagementsystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filmmanagementsystem.entities.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

	Director findBydirectorName(String directorName);

}
