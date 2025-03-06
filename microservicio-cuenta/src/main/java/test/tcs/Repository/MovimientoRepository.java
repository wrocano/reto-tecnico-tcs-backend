package test.tcs.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.tcs.entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetweenAndSaldoGreaterThanEqual(LocalDate fechaInicio, LocalDate fechaFin, double saldo);
}

