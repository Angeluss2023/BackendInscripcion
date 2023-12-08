package com.usuario.service.usuario.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.usuario.model.Usuario;
import com.usuario.service.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController{

    @Autowired
	private UsuarioService usuarioService;


@GetMapping
public ResponseEntity<List<Usuario>> ListUsuarios(){
    List<Usuario> usu = usuarioService.getAll();
    if(usu.isEmpty()){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(usu);
}

    @GetMapping( "/{id}")
	public ResponseEntity<Usuario> obtenerUser (@PathVariable ("id") Long id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> guardar (@RequestBody Usuario usuario){
		Usuario nuevo = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevo);	
	}
}