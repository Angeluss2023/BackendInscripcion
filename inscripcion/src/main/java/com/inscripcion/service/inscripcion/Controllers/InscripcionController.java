package com.inscripcion.service.inscripcion.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inscripcion.service.inscripcion.model.Inscripcion;
import com.inscripcion.service.inscripcion.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {

    @Autowired
	public InscripcionService inscripcionService;
	
	@PostMapping("/save")
	private ResponseEntity<Inscripcion> save (@RequestBody Inscripcion ins){
		Inscripcion temporal = inscripcionService.create(ins);
		
		try {
			return ResponseEntity.created(new URI("/api/inscripcion/save"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/allList")
	private ResponseEntity<List<Inscripcion>> allList (){
		return ResponseEntity.ok(inscripcionService.listCurso());
	}

	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Inscripcion>> usuario (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(inscripcionService.findById(id));
	}
	
	@GetMapping(value = "/curso/{id}")
	private ResponseEntity<List<Inscripcion>> curso (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(inscripcionService.byCursoId(id));
	}
	
	@GetMapping(value = "/usuario/{id}")
	private ResponseEntity<List<Inscripcion>> person (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(inscripcionService.byUsuarioId(id));
	}
}