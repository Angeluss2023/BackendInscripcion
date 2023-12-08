package com.patron.service.patron.FeignsPatron;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.patron.service.patron.model.Inscripcion;

@FeignClient(name = "inscripcion-service",url="http://localhost:8085")
public interface InscripcionP {
    /*DATOS DE INSCRIPCION */
    @GetMapping("/api/inscripcion/allList")
    public List<Inscripcion> addList();

    @PostMapping("/api/inscripcion/save")
    public Inscripcion save(@RequestBody Inscripcion ins);

    @GetMapping( "/api/inscripcion{id}")
    public Optional<Inscripcion> getInsId (@PathVariable ("id" )long id);   

    @GetMapping("/api/inscripcion/usuario/{id}")
	public List<Inscripcion> getIns(@PathVariable ("id") Integer id);
	
	@GetMapping("/api/inscripcion/curso/{id}")
	public List<Inscripcion> getCou(@PathVariable ("id") Integer id);
}