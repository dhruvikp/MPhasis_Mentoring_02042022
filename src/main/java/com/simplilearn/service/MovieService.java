package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Director;
import com.simplilearn.entity.Movie;
import com.simplilearn.respository.DirectorRepository;
import com.simplilearn.respository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	DirectorRepository directorRepository;
	
	public void saveMovie(Movie movie) {
		Optional<Director> directorOpt = directorRepository.findByDirectorName(movie.getDirector().getDirectorName());
		
		if(directorOpt.isPresent()) {
			movie.setDirector(directorOpt.get());
		}
		movieRepository.save(movie);
	}
	
	public void updateMovie() {
		Optional<Movie> movie = movieRepository.findById(3);
		if(movie.isPresent()) {
			Movie movieData = movie.get();
			movieData.setName("Pushpa 4");
			movieRepository.save(movieData);
		}
	}
	
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;				
	}
	
	public void delete(int id) {
		movieRepository.deleteById(id);
	}
	
	public List<Movie> getMovieByDirectorName(String directorName) {
		return movieRepository.findMovieByDirectorName(directorName);
	}
}
