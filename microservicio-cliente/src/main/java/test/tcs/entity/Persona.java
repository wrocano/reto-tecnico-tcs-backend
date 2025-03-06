package test.tcs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
