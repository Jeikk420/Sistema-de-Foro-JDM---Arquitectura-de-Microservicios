package foro.ms_categorias.service;
import foro.ms_categorias.dto.CategoriaRequestDTO;
import foro.ms_categorias.dto.CategoriaResponseDTO;
import foro.ms_categorias.model.Categoria;
import foro.ms_categorias.repository.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private static final Logger log = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private CategoriaRepository repository;

    public CategoriaResponseDTO crearCategoria(CategoriaRequestDTO dto) {
        log.info("Creando nueva categoría: " + dto.getNombre());

        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        Categoria guardada = repository.save(categoria);
        log.info("Categoría guardada con ID: " + guardada.getId());

        CategoriaResponseDTO response = new CategoriaResponseDTO();
        response.setId(guardada.getId());
        response.setNombre(guardada.getNombre());
        response.setDescripcion(guardada.getDescripcion());

        return response;
    }
    public CategoriaResponseDTO obtenerPorId(Long id) {
        // 1. Busca en la base de datos o lanza el error que atrapa el escudo
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));
        
        // 2. Transforma la entidad a DTO (Ajusta los datos según los atributos que tengas en tu DTO)
        CategoriaResponseDTO response = new CategoriaResponseDTO();
        response.setId(categoria.getId());
        response.setNombre(categoria.getNombre());
        // response.setDescripcion(categoria.getDescripcion()); // (Descomenta esto si tu categoría tiene descripción)
        
        return response;
    }
}