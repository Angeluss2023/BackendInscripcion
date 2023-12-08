package com.usuario.service.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.usuario.service.usuario.model.Usuario;
import com.usuario.service.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

   @Autowired
	private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario create (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}   

    public void delete (Usuario usuario) {
		 usuarioRepository.delete(usuario);
	}

     public Optional<Usuario> findById (long id) {
		return usuarioRepository.findById(id);
	} 

    public Usuario save(Usuario usuario){
        Usuario nuevo = usuarioRepository.save(usuario);
        return nuevo;
    }
}