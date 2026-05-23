package ms_hilos.ms_hilos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Le decimos a Feign: "Conéctate al microservicio de usuarios en el puerto 8081"
@FeignClient(name = "ms-usuarios", url = "http://localhost:8081/api/usuarios")
public interface UsuarioClient {

    // Simulamos que hacemos un GET a la ruta /api/usuarios/{id}
    @GetMapping("/{id}")
    Object obtenerUsuarioPorId(@PathVariable("id") Long id);
}