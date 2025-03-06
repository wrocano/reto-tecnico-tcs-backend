package test.tcs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tcs.Repository.CuentaRepository;
import test.tcs.Repository.MovimientoRepository;
import test.tcs.entity.Cuenta;
import test.tcs.entity.Movimiento;
import test.tcs.exceptions.SaldoInsuficienteException;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    
    @Autowired
    private CuentaRepository cuentaRepository;

    public Movimiento registrarMovimiento(Long cuentaId, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
            .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (nuevoSaldo < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }
        
        cuenta.actualizarSaldo(movimiento.getValor());
        cuentaRepository.save(cuenta);
        
        movimiento.setSaldo(cuenta.getSaldoInicial());
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> obtenerMovimientos() {
        return movimientoRepository.findAll();
    }

    public List<Movimiento> obtenerMovimientosPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return movimientoRepository.findByFechaBetweenAndSaldoGreaterThanEqual(fechaInicio, fechaFin, 0);
    }
}