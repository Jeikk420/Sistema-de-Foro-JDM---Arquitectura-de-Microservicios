package foro.ms_reacciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReaccionRequestDTO {
    @NotBlank(message = "El tipo de reacción es obligatorio")
    private String tipo;
    
    @NotNull(message = "Falta el ID del usuario")
    private Long usuarioId;
    
    @NotNull(message = "Falta el ID del hilo")
    private Long hiloId;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getHiloId() { return hiloId; }
    public void setHiloId(Long hiloId) { this.hiloId = hiloId; }
}