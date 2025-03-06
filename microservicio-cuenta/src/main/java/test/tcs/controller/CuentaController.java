package test.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tcs.entity.Cuenta;
import test.tcs.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.guardarCuenta(cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> obtenerCuentas() {
        return ResponseEntity.ok(cuentaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return ResponseEntity.ok(cuentaService.actualizarCuenta(id, cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }
}