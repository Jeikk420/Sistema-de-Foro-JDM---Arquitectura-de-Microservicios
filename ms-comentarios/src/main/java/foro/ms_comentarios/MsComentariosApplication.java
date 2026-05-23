package foro.ms_comentarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <-- Vital para la doble llamada
public class MsComentariosApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsComentariosApplication.class, args);
    }
}
