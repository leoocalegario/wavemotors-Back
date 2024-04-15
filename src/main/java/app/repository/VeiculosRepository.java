package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Veiculos;

public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
	
}
