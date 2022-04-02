package com.simplilearn.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	Movie findByName(String name);

	@Query("select movie from Movie movie left join Director director on movie.director.id =  director.id  Where director.directorName = :directorName")
	List<Movie> findMovieByDirectorName(@Param("directorName") String directorName);
}
