package com.foro.ms_usuarios.service;

import com.foro.ms_usuarios.dto.UsuarioRequestDTO;
import com.foro.ms_usuarios.dto.UsuarioResponseDTO;
import com.foro.ms_usuarios.model.Usuario;
import com.foro.ms_usuarios.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository repository;

   
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        log.info("Iniciando creación de usuario: " + dto.getUsername());

        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        Usuario guardado = repository.save(usuario);
        log.info("Usuario guardado exitosamente en BD con ID: " + guardado.getId());

        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(guardado.getId());
        response.setUsername(guardado.getUsername());
        response.setEmail(guardado.getEmail());

        return response;
    } 

    
    public UsuarioResponseDTO obtenerPorId(Long id) {
        log.info("Buscando usuario con ID: " + id);
        
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
                
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(usuario.getId());
        response.setUsername(usuario.getUsername());
        response.setEmail(usuario.getEmail());
        
        return response;
    }
}