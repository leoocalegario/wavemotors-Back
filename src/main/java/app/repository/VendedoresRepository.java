package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vendedores;

public interface VendedoresRepository extends JpaRepository<Vendedores, Long> {

}
