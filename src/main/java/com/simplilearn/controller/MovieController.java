package com.simplilearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	
	@GetMapping("/movies")
	private List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@PostMapping("/movies")
	private int saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}
	
	@DeleteMapping("/movies/{id}")
	private void deleteMovie(@PathVariable("id") int id) {
		movieService.delete(id);
	}
	
	@GetMapping("/movies/director/{name}")
	private List<String> getMovieByDirectorName(@PathVariable("name") String name) {
		List<Movie> movies= movieService.getMovieByDirectorName(name);
		List<String> movieNames = new ArrayList<>();
		
		if(movies!=null && movies.size()>0) {
			for(Movie movie : movies) {
				movieNames.add(movie.getName());
			}
		}
		
		return movieNames;
	}
	
	
}
