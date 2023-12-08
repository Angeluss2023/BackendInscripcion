package com.inscripcion.service.inscripcion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	private int idUsuario;
    private int idCurso;
	
	public Inscripcion() {
		
	}

    public Inscripcion(int id, int idUsuario, int idCurso) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idCurso = idCurso;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}