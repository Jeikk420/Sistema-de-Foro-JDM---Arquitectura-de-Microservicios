package ms_hilos.ms_hilos.service;

import ms_hilos.ms_hilos.client.UsuarioClient;
import ms_hilos.ms_hilos.dto.HiloRequestDTO;
import ms_hilos.ms_hilos.dto.HiloResponseDTO;
import ms_hilos.ms_hilos.model.Hilo;
import ms_hilos.ms_hilos.repository.HiloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiloService {

    private static final Logger log = LoggerFactory.getLogger(HiloService.class);

    @Autowired
    private HiloRepository repository;

    
    @Autowired
    private UsuarioClient usuarioClient;

    public HiloResponseDTO crearHilo(HiloRequestDTO dto) {
        log.info("Iniciando creación de hilo. Verificando usuario ID: " + dto.getUsuarioId());

        try {
            
            Object usuarioValido = usuarioClient.obtenerUsuarioPorId(dto.getUsuarioId());
            
            if (usuarioValido == null) {
                throw new RuntimeException("El usuario no existe");
            }
            log.info("Usuario validado correctamente mediante Feign Client.");

        } catch (Exception e) {
            log.error("Error de comunicación remota o el usuario no existe: " + e.getMessage());
            throw new RuntimeException("No se puede crear el hilo: El usuario ingresado no existe o ms-usuarios está apagado.");
        }

        
        Hilo hilo = new Hilo();
        hilo.setTitulo(dto.getTitulo());
        hilo.setContenido(dto.getContenido());
        hilo.setUsuarioId(dto.getUsuarioId());
        hilo.setCategoriaId(dto.getCategoriaId());

        Hilo guardado = repository.save(hilo);
        log.info("Hilo guardado exitosamente con ID: " + guardado.getId());

        
        HiloResponseDTO response = new HiloResponseDTO();
        response.setId(guardado.getId());
        response.setTitulo(guardado.getTitulo());
        response.setContenido(guardado.getContenido());
        response.setUsuarioId(guardado.getUsuarioId());
        response.setFechaCreacion(guardado.getFechaCreacion());

        return response;
    }
    public HiloResponseDTO obtenerPorId(Long id) {
        log.info("Buscando hilo con ID: " + id);
        
        Hilo hilo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hilo no encontrado con ID: " + id));
                
        HiloResponseDTO response = new HiloResponseDTO();
        response.setId(hilo.getId());
        response.setTitulo(hilo.getTitulo());
        response.setContenido(hilo.getContenido());
        response.setUsuarioId(hilo.getUsuarioId());
        response.setFechaCreacion(hilo.getFechaCreacion());
        
        return response;
    }
}