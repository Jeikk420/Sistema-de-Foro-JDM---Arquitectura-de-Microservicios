package foro.ms_reacciones.service;

import foro.ms_reacciones.client.HiloClient;
import foro.ms_reacciones.client.UsuarioClient;
import foro.ms_reacciones.dto.ReaccionRequestDTO;
import foro.ms_reacciones.dto.ReaccionResponseDTO;
import foro.ms_reacciones.model.Reaccion;
import foro.ms_reacciones.repository.ReaccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaccionService {
    private static final Logger log = LoggerFactory.getLogger(ReaccionService.class);

    @Autowired private ReaccionRepository repository;
    @Autowired private UsuarioClient usuarioClient;
    @Autowired private HiloClient hiloClient;

    public ReaccionResponseDTO crearReaccion(ReaccionRequestDTO dto) {
        log.info("Validando reacción del usuario " + dto.getUsuarioId() + " al hilo " + dto.getHiloId());

        try {
            usuarioClient.obtenerPorId(dto.getUsuarioId());
            hiloClient.obtenerPorId(dto.getHiloId());
            log.info("Validaciones remotas exitosas para la reacción.");
        } catch (Exception e) {
            log.error("Error al validar usuario o hilo: " + e.getMessage());
            throw new RuntimeException("No se pudo procesar la reacción. Usuario o Hilo inválido.");
        }

        Reaccion reaccion = new Reaccion();
        reaccion.setTipo(dto.getTipo());
        reaccion.setUsuarioId(dto.getUsuarioId());
        reaccion.setHiloId(dto.getHiloId());

        Reaccion guardada = repository.save(reaccion);

        ReaccionResponseDTO response = new ReaccionResponseDTO();
        response.setId(guardada.getId());
        response.setTipo(guardada.getTipo());
        response.setUsuarioId(guardada.getUsuarioId());
        response.setHiloId(guardada.getHiloId());
        response.setFechaCreacion(guardada.getFechaCreacion());
        
        return response;
    }
}
