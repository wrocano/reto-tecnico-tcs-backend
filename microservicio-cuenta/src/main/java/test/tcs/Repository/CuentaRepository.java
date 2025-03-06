package test.tcs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.tcs.entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}