package com.curso.service.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.service.curso.model.Curso;
import com.curso.service.curso.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listCource(){
		return cursoRepository.findAll();
	}
	
	public Curso create (Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Optional<Curso> findById(Long id){
		return cursoRepository.findById(id);
	}  
}