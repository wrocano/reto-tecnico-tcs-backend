package test.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.tcs.Repository.CuentaRepository;
import test.tcs.entity.Cuenta;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public List<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }

    public Cuenta obtenerPorId(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada) {
        Cuenta cuenta = obtenerPorId(id);
        cuenta.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaActualizada.getSaldoInicial());
        cuenta.setEstado(cuentaActualizada.isEstado());
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
