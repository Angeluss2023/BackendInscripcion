package com.patron.service.patron.FeignsPatron;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.patron.service.patron.model.Usuario;


@FeignClient(name = "usuario-service",url="http://localhost:8005")
public interface UsuarioP {

    /*DATOS DE USUARIOS */
    @GetMapping("/usuario")
    public List<Usuario> addList();

    @PostMapping("/usuario")
    public Usuario saveUse(@RequestBody Usuario use);

    @GetMapping( "/usuario/{id}")
    public Optional<Usuario> getUsu(@PathVariable ("id" )long id);   
}