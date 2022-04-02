package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="director_02042022")
public class Director {

	@Id
	@GeneratedValue
	@Column(name="director_id")
	private int id;
	
	@Column(name="director_name")
	private String directorName;
	
	
	@OneToMany(mappedBy="director", cascade=CascadeType.ALL)
	private List<Movie> movies;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDirectorName() {
		return directorName;
	}


	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}


	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
