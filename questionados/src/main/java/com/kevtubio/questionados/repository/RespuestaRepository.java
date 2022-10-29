package com.kevtubio.questionados.repository;

import com.kevtubio.questionados.entity.Respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
}
