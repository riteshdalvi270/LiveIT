package com.liveit.service;

import com.liveit.model.MovieVo;
import com.liveit.repository.jpa.entity.MovieEntity;

import java.text.ParseException;
import java.util.List;

public interface MovieService {

	MovieEntity persist(MovieVo movie) throws Exception;
	
	List<MovieEntity> getMovies();
	
	MovieEntity getMovie(int id) throws Exception;

	MovieEntity update(MovieVo movie) throws ParseException;

}
