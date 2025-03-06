package test.tcs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoInicial;
    private boolean estado;

    public void actualizarSaldo(double monto) {
        this.saldoInicial += monto;
    }
}
