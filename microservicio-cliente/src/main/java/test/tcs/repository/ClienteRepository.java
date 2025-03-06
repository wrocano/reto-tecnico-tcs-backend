package test.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.tcs.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
