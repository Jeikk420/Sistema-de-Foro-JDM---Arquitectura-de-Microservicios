package foro.ms_notificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NotificacionRequestDTO {
    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;
    
    @NotNull(message = "Falta el ID del usuario receptor")
    private Long usuarioId;

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}