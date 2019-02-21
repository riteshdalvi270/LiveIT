package com.liveit.controller;

import com.liveit.model.MovieVo;
import com.liveit.repository.jpa.entity.MovieEntity;
import com.liveit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/movies")
@Controller
public class MoviesEndpoint {

	@Autowired
	private MovieService movieService;

	public ResponseEntity<?> addMovies(@Valid @RequestBody MovieVo movie) {

		try {
			MovieEntity newMovie = movieService.persist(movie);

			return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
		}catch(Exception e) {
			e.getStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getMovies() {
		
		 List<MovieEntity> movies = movieService.getMovies();
		 
		 if(movies == null || movies.isEmpty()) {
			 ResponseEntity.noContent().build();
		 }
		 
		 return ResponseEntity.ok(movies);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<?> getMovie(@PathVariable long id) {

		MovieEntity movie = null;
		try {
			movie = movieService.getMovie(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return ResponseEntity.ok(movie);
			
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<?> updateMovie(@Valid @RequestBody MovieVo movieVo) {

		MovieEntity updatedMovieRecord = null;

		try {
			updatedMovieRecord = movieService.update(movieVo);

			return ResponseEntity.status(HttpStatus.OK).body(updatedMovieRecord);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
