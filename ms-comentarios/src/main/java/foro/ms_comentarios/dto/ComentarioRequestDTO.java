package foro.ms_comentarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ComentarioRequestDTO {
    @NotBlank(message = "El comentario no puede estar vacío")
    private String contenido;
    @NotNull(message = "Falta el ID del usuario")
    private Long usuarioId;
    @NotNull(message = "Falta el ID del hilo")
    private Long hiloId;

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getHiloId() { return hiloId; }
    public void setHiloId(Long hiloId) { this.hiloId = hiloId; }
}
