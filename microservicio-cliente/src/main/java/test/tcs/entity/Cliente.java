package test.tcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cliente extends Persona {
    @Column(unique = true, nullable = false)
    private String clienteId;
    private String contraseña;
    private boolean estado;
}
