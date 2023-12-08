package com.patron.service.patron.Controladores;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patron.service.patron.Services.Microservices;
import com.patron.service.patron.model.Curso;
import com.patron.service.patron.model.Inscripcion;
import com.patron.service.patron.model.Usuario;

@RestController
@RequestMapping("/micro")
public class MicroservicesControlador {

@Autowired
    private  Microservices microser;
    
    //Person
	@PostMapping("/save")
	public ResponseEntity<Usuario> save (@RequestBody Usuario usu){
		Usuario usua = microser.saveUse(usu);
		return ResponseEntity.ok(usua);
	}

    @GetMapping(value = "{id}")
	private ResponseEntity<Optional<Usuario>> user (@PathVariable ("id") long id){
		return ResponseEntity.ok(microser.getUseId(id));
	}

    //Cursos
    @GetMapping("/getCurso/{id}")
	public ResponseEntity<Map<String, Optional>> getCou(@PathVariable("id") int id){
		Map<String,Optional> result = microser.getCurso(id);
		return ResponseEntity.ok(result);
	}

    @GetMapping("/getCursoall")
    public ResponseEntity<List<Curso>> listallCource(){
        List<Curso> cou = microser.getallCource();
        if(cou.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cou);
    }
    
    //Inscripciones
    @PostMapping("/inscripciones/save")
	public ResponseEntity<Inscripcion> saveIns(@RequestBody Inscripcion ins){
		Inscripcion nueIns = microser.saveIns(ins);
		return ResponseEntity.ok(nueIns);
	} 

	@GetMapping("/getMisCursos/{id}")
	public ResponseEntity<Map<String, Object>> listCursos(@PathVariable("id") int id){
		Map<String,Object> result = microser.getCourceUser(id);
		return ResponseEntity.ok(result);
	}

    @GetMapping("/getIntegrantes/{id}")
	public ResponseEntity<Map<String, Object>> listCourse(@PathVariable("id") int id){
		Map<String,Object> result = microser.getCour(id);
		return ResponseEntity.ok(result);
	}
}