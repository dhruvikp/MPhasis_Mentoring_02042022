package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie_02042022")
public class Movie {

	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private int id;

	@Column(name = "movie_name")
	private String name;

	@Column(name = "movie_genre")
	private String genre;
 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id")
	private Director director;

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
