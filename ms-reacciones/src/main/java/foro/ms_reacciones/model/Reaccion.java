package foro.ms_reacciones.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reacciones")
public class Reaccion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    
    @Column(nullable = false) private String tipo; 
    @Column(nullable = false) private Long usuarioId;
    @Column(nullable = false) private Long hiloId;
    
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getHiloId() { return hiloId; }
    public void setHiloId(Long hiloId) { this.hiloId = hiloId; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
