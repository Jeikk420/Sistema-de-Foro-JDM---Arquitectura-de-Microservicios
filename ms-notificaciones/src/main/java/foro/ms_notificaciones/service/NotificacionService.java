package foro.ms_notificaciones.service;

import foro.ms_notificaciones.client.UsuarioClient;
import foro.ms_notificaciones.dto.NotificacionRequestDTO;
import foro.ms_notificaciones.dto.NotificacionResponseDTO;
import foro.ms_notificaciones.model.Notificacion;
import foro.ms_notificaciones.repository.NotificacionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {
    private static final Logger log = LoggerFactory.getLogger(NotificacionService.class);

    @Autowired private NotificacionRepository repository;
    @Autowired private UsuarioClient usuarioClient;

    public NotificacionResponseDTO crearNotificacion(NotificacionRequestDTO dto) {
        log.info("Validando existencia del usuario " + dto.getUsuarioId() + " para enviar notificación.");

        try {
            usuarioClient.obtenerPorId(dto.getUsuarioId());
            log.info("Usuario validado correctamente.");
        } catch (Exception e) {
            log.error("Error: El usuario receptor no existe. " + e.getMessage());
            throw new RuntimeException("No se puede enviar la notificación. Usuario inválido.");
        }

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(dto.getMensaje());
        notificacion.setUsuarioId(dto.getUsuarioId());

        Notificacion guardada = repository.save(notificacion);

        NotificacionResponseDTO response = new NotificacionResponseDTO();
        response.setId(guardada.getId());
        response.setMensaje(guardada.getMensaje());
        response.setUsuarioId(guardada.getUsuarioId());
        response.setLeida(guardada.isLeida());
        response.setFechaCreacion(guardada.getFechaCreacion());
        
        return response;
    }
    public NotificacionResponseDTO obtenerPorId(Long id) {
        Notificacion notificacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con ID: " + id));
        
        NotificacionResponseDTO response = new NotificacionResponseDTO();
        response.setId(notificacion.getId());
        
        // OJO: Ajusta o descomenta esto según los campos que tenga tu NotificacionResponseDTO
        // response.setMensaje(notificacion.getMensaje());
        // response.setUsuarioId(notificacion.getUsuarioId());
        
        return response;
    }
}