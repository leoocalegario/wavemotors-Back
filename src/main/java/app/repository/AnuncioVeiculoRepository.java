package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.AnuncioVeiculo;

public interface AnuncioVeiculoRepository extends JpaRepository<AnuncioVeiculo, Long> {
	
	public AnuncioVeiculo findByidAnuncio (Long idAnuncio);
	
	@Query("From Veiculos v where v.nomeVeiculo LIKE %:nomeVeiculo")
	public List <AnuncioVeiculo> findByNomeVeiculoLike(String nomeVeiculo);
	
	
}
