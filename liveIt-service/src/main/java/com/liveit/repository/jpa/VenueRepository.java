package com.liveit.repository.jpa;

import com.liveit.repository.jpa.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Short> {

    Optional<Venue> findByType(String type);
}
