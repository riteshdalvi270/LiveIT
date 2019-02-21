package com.liveit.service.impl;

import com.liveit.model.MovieVo;
import com.liveit.repository.jpa.GenreRepository;
import com.liveit.repository.jpa.MovieRepository;
import com.liveit.repository.jpa.VenueRepository;
import com.liveit.repository.jpa.entity.Genre;
import com.liveit.repository.jpa.entity.MovieEntity;
import com.liveit.repository.jpa.entity.Venue;
import com.liveit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	VenueRepository venueRepository;

	@Autowired
	GenreRepository genreRepository;

	@Override
	@Transactional
	public MovieEntity persist(MovieVo movie){

		Optional<MovieEntity> movieVersionEntityOptional =
				movieRepository.findByNameAndVersionEndDateIsNull(movie.getName());

		if(movieVersionEntityOptional.isPresent()) {

			throw new IllegalStateException("Movie already exist");
		}

		final MovieEntity movieEntity = populateMovieEntity(movie);

		MovieEntity savedMovieEntity = movieRepository.save(movieEntity);

		return savedMovieEntity;
	}

	@Override
	@Transactional
	public MovieEntity update(MovieVo updatedMovie) {

        Optional<MovieEntity> optionalMovieEntity =
				movieRepository.findByMovieIdAndVersionEndDateIsNull(updatedMovie.getMovieID());

        if(!optionalMovieEntity.isPresent()) {
            throw new RuntimeException("Movie does not exist");
        }

        MovieEntity movieEntity = optionalMovieEntity.get();

        movieRepository.versionMovie(movieEntity.getMovieId());

        final MovieEntity updatedMovieEntity = populateMovieEntity(updatedMovie);

        movieRepository.save(updatedMovieEntity);

        return updatedMovieEntity;
    }

	@Override
	@Transactional(readOnly=true)
	public List<MovieEntity> getMovies() {

		List<MovieEntity> moviesEntity = movieRepository.findByVersionEndDateIsNull();

		return moviesEntity;
	}

	@Override
	@Transactional(readOnly=true)
	public MovieEntity getMovie(long id){

		Optional<MovieEntity> optionalMovie = movieRepository.findByMovieIdAndVersionEndDateIsNull(id);

		if(!optionalMovie.isPresent()) {
			 throw new IllegalStateException("Movie does not exist with the id passed");
		}

		return optionalMovie.get();
	}

	private MovieEntity populateMovieEntity(MovieVo movieVo) {

		Optional<Genre> genre = genreRepository.findByType(movieVo.getGenre());

		if(!genre.isPresent()) {
			throw new InternalError("Genre not found, please create one first");
		}

		Optional<Venue> venue = venueRepository.findByType(movieVo.getVenue());

		if(!venue.isPresent()) {
			throw new InternalError("Venue not found, please create one first");
		}

		return MovieEntity.builder().name(movieVo.getName())
				.amountPayed(movieVo.getAmountPayed()).genre(genre.get()).venue(venue.get()).imdbURL(movieVo.getImdbURL())
				.rottenTomatoesURL(movieVo.getRottenTomatoesURL()).ourRating(movieVo.getOurRating())
				.releasedDate(movieVo.getReleasedDate()).screenMode(movieVo.getScreenMode()).type(movieVo.getType())
				.watchDate(movieVo.getWatchDate()).versionStartDate(LocalDate.now()).versionEndDate(null).build();
	}
}
