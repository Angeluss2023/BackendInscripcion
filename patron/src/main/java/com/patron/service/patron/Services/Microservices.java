package com.patron.service.patron.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patron.service.patron.FeignsPatron.CursoP;
import com.patron.service.patron.FeignsPatron.InscripcionP;
import com.patron.service.patron.FeignsPatron.UsuarioP;
import com.patron.service.patron.model.Curso;
import com.patron.service.patron.model.Inscripcion;
import com.patron.service.patron.model.Usuario;

@Service
public class Microservices {

    @Autowired
	private InscripcionP insFeigns;
	
	@Autowired
	private CursoP curFeigns;

    @Autowired
	private UsuarioP usuFeigns;
    
    /*usuario */

    public Usuario saveUse(Usuario use){

        Usuario usuario  = usuFeigns.saveUse(use);
        return usuario;

    }

    public Optional<Usuario> getUseId(long id){
        return usuFeigns.getUsu(id);
    }

    /*datos curso */

    public Map<String,Optional> getCurso(int courseid){
		Map<String,Optional> result = new HashMap<>();
		Optional<Curso> cour = curFeigns.getCur(courseid);
		if(cour.isEmpty()) {
			result.put("Cursos", null);
		}{
			result.put("Cursos:",cour);
		}
		return result;
	}

	public List<Curso> getallCource(){
		return curFeigns.addList();
	}

    //Inscripciones
	public Inscripcion saveIns(Inscripcion ins) {
		Inscripcion nuIns = insFeigns.save(ins);
		return nuIns;
	} 

	public Map<String,Object> getCourceUser(int userid){
		Map<String,Object> result = new HashMap<>();
		Usuario user = usuFeigns.getUsu(userid).orElse(null);
		
		if(user == null) {
			result.put("Mensaje"," El usuario no existe");
			return result;
		}
		
		result.put("Usuario", user);
		List<Inscripcion> ins = insFeigns.getIns(userid);
		if(ins.isEmpty()) {
			result.put("Cursos del  Usuario:", "En ningun Curso");
		}{
			result.put("Cursos del Usuario:",ins);
		}
		return result;
	}

    public Map<String,Object> getCour(int courseid){
		Map<String,Object> result = new HashMap<>();
		
		List<Inscripcion> ins = insFeigns.getCou(courseid);
		if(ins.isEmpty()) {
			result.put("Curso Integrantes", "Ningun estudiante");
		}{
			result.put("Curso Integrantes:",ins);
		}
		return result;
	}
}