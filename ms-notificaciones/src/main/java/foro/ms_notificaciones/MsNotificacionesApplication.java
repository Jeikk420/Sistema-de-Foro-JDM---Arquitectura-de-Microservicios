package foro.ms_notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <-- Vital para llamar a ms-usuarios
public class MsNotificacionesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsNotificacionesApplication.class, args);
    }
}