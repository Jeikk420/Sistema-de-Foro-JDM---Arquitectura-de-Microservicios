package foro.ms_notificaciones.dto;

import java.time.LocalDateTime;

public class NotificacionResponseDTO {
    private Long id;
    private String mensaje;
    private Long usuarioId;
    private boolean leida;
    private LocalDateTime fechaCreacion;

    // Genera los Getters y Setters para las 5 variables aquí
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public boolean isLeida() { return leida; }
    public void setLeida(boolean leida) { this.leida = leida; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}