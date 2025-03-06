package test.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.tcs.entity.Movimiento;
import test.tcs.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/{cuentaId}")
    public ResponseEntity<Movimiento> registrarMovimiento(@PathVariable Long cuentaId, @RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = movimientoService.registrarMovimiento(cuentaId, movimiento);
        return ResponseEntity.ok(nuevoMovimiento);
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> obtenerMovimientos() {
        return ResponseEntity.ok(movimientoService.obtenerMovimientos());
    }
}
