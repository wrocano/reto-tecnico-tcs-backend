package test.tcs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.tcs.entity.Movimiento;
import test.tcs.service.MovimientoService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> obtenerReporte(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        List<Movimiento> reporte = movimientoService.obtenerMovimientosPorRangoFechas(fechaInicio, fechaFin);
        return ResponseEntity.ok(reporte);
    }
}