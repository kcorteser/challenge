package com.kcorteser.challenge.repositories;

import com.kcorteser.challenge.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends JpaRepository<Details,Long> {
    Optional<List<Details>> findAllByTypeLikeIgnoreCaseAndDate(@Param("type") String type,@Param("date") LocalDate date);
}
