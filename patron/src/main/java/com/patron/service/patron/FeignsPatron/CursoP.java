package com.patron.service.patron.FeignsPatron;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.patron.service.patron.model.Curso;

@FeignClient(name = "curso-service",url="http://localhost:8082")
public interface CursoP {
     /*DATOS DE Curso */

    @GetMapping("/cursos")
    public List<Curso> addList();

    @PostMapping("/cursos/save")
    public Curso save(@RequestBody Curso cur);

    @GetMapping( "/cursos/{id}")
    public Optional<Curso> getCur (@PathVariable ("id" )long id);   
}