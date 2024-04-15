package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vendedores;

public interface VendedoresRepository extends JpaRepository<Vendedores, Long> {
	
	public Vendedores findByIdVendedor(Long idVendedor);
	
	@Query("FROM Vendedores v where v.nome LIKE %:nome")
	public List<Vendedores> findByNomeLike(String nome);
	
	public Vendedores findByEmail(String email);
}
