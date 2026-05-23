package foro.ms_reacciones.dto;

import java.time.LocalDateTime;

public class ReaccionResponseDTO {
    private Long id;
    private String tipo;
    private Long usuarioId;
    private Long hiloId;
    private LocalDateTime fechaCreacion;

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