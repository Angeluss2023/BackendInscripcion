package com.curso.service.curso.Controllers;

import com.curso.service.curso.model.Curso;
import com.curso.service.curso.repository.CursoRepository;
import com.curso.service.curso.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;
    
    @Autowired
    public CursoService cursoService;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @PostMapping("/save")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable long id, @RequestBody Curso curso) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setPrecio(curso.getPrecio());
            return cursoRepository.save(cursoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable long id) {
        cursoRepository.deleteById(id);
    }
}