package com.liveit.repository.jpa;

import com.liveit.repository.jpa.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Short> {

    Optional<Genre> findByType(String type);
}
