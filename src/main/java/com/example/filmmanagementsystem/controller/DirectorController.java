package com.example.filmmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.filmmanagementsystem.entities.Director;
import com.example.filmmanagementsystem.entities.DirectorErrorResponse;
import com.example.filmmanagementsystem.exception.InvalidDataException;
import com.example.filmmanagementsystem.repos.DirectorRepository;
import com.example.filmmanagementsystem.service.DirectorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DirectorController {

	@Autowired
	DirectorService directorService;
	@Autowired
	DirectorRepository repos;
	
	@PostMapping("/director/create")
	public Director createDirector(@RequestBody Director director) {
		return directorService.createDirector(director);	
	}
	
	@PutMapping(value = "/director/update/{directorName}")
	public Director updateDirector(@RequestBody Director director,@PathVariable("directorName") String directorName) throws InvalidDataException {
		Director director2 = repos.findBydirectorName(directorName);
		if(director2.getAge() == director.getAge() && director2.getAwardCount() == director.getAwardCount()) {
			throw new InvalidDataException("Cannot update the existing data itself");
		}
		return directorService.updateDirector(director,director2);
	}
	
	@ExceptionHandler
	public ResponseEntity<DirectorErrorResponse> handleException(InvalidDataException e){
		DirectorErrorResponse p = new DirectorErrorResponse();
		p.setStatus(HttpStatus.NOT_FOUND);
		p.setMessage(e.getMessage());
		p.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<DirectorErrorResponse>(p, null, HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/director/fetch/{movieName}")
	public List<Director>getDirector(@PathVariable("movieName")String movieName){
		return directorService.getDirector(movieName);
	}
	
	@GetMapping("/director/get/{directorName}")
	public Director getParticularDirector(@PathVariable("directorName")String directorName) {
		return directorService.getParticularDirector(directorName);
	}
	
	@GetMapping("/director/getAll")
	public List<Director>getAllDirectors(){
		return directorService.getAllDirectors();
	}
	

}
