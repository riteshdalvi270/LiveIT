package com.liveit.repository.jpa;

import com.liveit.repository.jpa.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly=true)
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    @Modifying
	MovieEntity save(MovieEntity movieEntity);

    @Query("Select CASE WHEN count(mv) > 0 THEN TRUE ELSE FALSE END from MovieEntity mv where mv.name = :name and mv.versionEndDate is null")
    boolean existsByNameAndVersionEndDateIsNull(@Param("name") String name);

    Optional<MovieEntity> findByMovieIdAndVersionEndDateIsNull(int movieId);

    List<MovieEntity> findByVersionEndDateIsNull();

    /*@Query("Select me from MovieEntity me where me.name = :name and me.versionEndDate is null")
    Optional<MovieEntity> getMovieEntityByName(String name);

	@Query("SELECT me from MovieEntity me where me.id = :id and " +
            "me.versionEndDate is null")
	Optional<MovieEntity> getMovie(@Param("id") long id);
	
	@Query("Select me from MovieEntity me where me.versionEndDate is null")
	List<MovieEntity> getMovies();*/

	@Query("UPDATE MovieEntity me set me.versionEndDate=Now() where me.movieId=:movieId")
	void versionMovie(@Param("movieId") long movieId);
}
