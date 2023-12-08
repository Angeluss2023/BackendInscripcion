package com.inscripcion.service.inscripcion.repository;

import com.inscripcion.service.inscripcion.model.Inscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

    List<Inscripcion> findByidCurso(int idCurso);	
	List<Inscripcion> findByidUsuario(int idUsuario);	

}