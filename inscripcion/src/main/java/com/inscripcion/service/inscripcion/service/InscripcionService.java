package com.inscripcion.service.inscripcion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.service.inscripcion.model.Inscripcion;
import com.inscripcion.service.inscripcion.repository.InscripcionRepository;


@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository insRepository;
	
	public List<Inscripcion> listCurso(){
		return insRepository.findAll();
	}
	
	public Inscripcion create (Inscripcion ins) {
		return insRepository.save(ins);
	}
	
	public Optional<Inscripcion> findById(int id){
		return insRepository.findById(id);
	}
	
	public List<Inscripcion> byCursoId(int idCurso){
		return insRepository.findByidCurso(idCurso);
	}
	
	public List<Inscripcion> byUsuarioId(int idUsuario){
		return insRepository.findByidUsuario(idUsuario);
	}

	public InscripcionRepository getInsRepository() {
		return insRepository;
	}

	public void setInsRepository(InscripcionRepository insRepository) {
		this.insRepository = insRepository;
	}
}