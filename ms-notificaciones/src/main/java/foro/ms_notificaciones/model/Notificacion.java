package foro.ms_notificaciones.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    
    @Column(nullable = false) private String mensaje;
    @Column(nullable = false) private Long usuarioId; 
    private boolean leida = false;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

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