package foro.ms_comentarios.service;

import foro.ms_comentarios.client.HiloClient;
import foro.ms_comentarios.client.UsuarioClient;
import foro.ms_comentarios.dto.ComentarioRequestDTO;
import foro.ms_comentarios.dto.ComentarioResponseDTO;
import foro.ms_comentarios.model.Comentario;
import foro.ms_comentarios.repository.ComentarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private static final Logger log = LoggerFactory.getLogger(ComentarioService.class);

    @Autowired private ComentarioRepository repository;
    @Autowired private UsuarioClient usuarioClient;
    @Autowired private HiloClient hiloClient;

    public ComentarioResponseDTO crearComentario(ComentarioRequestDTO dto) {
        log.info("Validando usuario " + dto.getUsuarioId() + " e hilo " + dto.getHiloId());

        try {
            // DOBLE LLAMADA: Revisamos ambos motores
            usuarioClient.obtenerPorId(dto.getUsuarioId());
            hiloClient.obtenerPorId(dto.getHiloId());
            log.info("Ambas validaciones remotas exitosas.");
        } catch (Exception e) {
            log.error("Fallo de validación remota: " + e.getMessage());
            throw new RuntimeException("El usuario o el hilo no existen.");
        }

        Comentario comentario = new Comentario();
        comentario.setContenido(dto.getContenido());
        comentario.setUsuarioId(dto.getUsuarioId());
        comentario.setHiloId(dto.getHiloId());

        Comentario guardado = repository.save(comentario);

        ComentarioResponseDTO response = new ComentarioResponseDTO();
        response.setId(guardado.getId());
        response.setContenido(guardado.getContenido());
        response.setUsuarioId(guardado.getUsuarioId());
        response.setHiloId(guardado.getHiloId());
        
        return response;
    }
    public ComentarioResponseDTO obtenerPorId(Long id) {
        Comentario comentario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con ID: " + id));
        
        ComentarioResponseDTO response = new ComentarioResponseDTO();
        response.setId(comentario.getId());
        response.setContenido(comentario.getContenido()); // Ajusta "contenido" según los campos de tu modelo
        
        return response;
    }
}
