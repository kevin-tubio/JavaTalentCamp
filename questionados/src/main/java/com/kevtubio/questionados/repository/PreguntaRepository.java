package com.kevtubio.questionados.repository;

import com.kevtubio.questionados.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    @Query(
            value = "SELECT * FROM pregunta ORDER BY RAND() LIMIT 1",
            nativeQuery = true
    )
    Optional<Pregunta> findRandom();

}
