package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.AnuncioVeiculo;
import app.repository.AnuncioVeiculoRepository;

@Service
public class AnuncioVeiculoService {

	@Autowired
	private AnuncioVeiculoRepository anuncioveiculorepository;

	public String save(AnuncioVeiculo anuncioveiculo) {

		this.anuncioveiculorepository.save(anuncioveiculo);
		return anuncioveiculo.getNomeVeiculo() + " salvo com sucesso";
	}

	public String update(Long id, AnuncioVeiculo anuncioveiculo) {
		anuncioveiculo.setIdAnuncio(id);
		this.anuncioveiculorepository.save(anuncioveiculo);
		return anuncioveiculo.getNomeVeiculo() + "atualizado com sucesso";
	}

	public String delete(Long idAnuncio) {
		this.anuncioveiculorepository.deleteById(idAnuncio);
		return "Anuncio deletado com sucesso";
	}

	public List<AnuncioVeiculo> findAll() {
		return this.anuncioveiculorepository.findAll();
	}

	public AnuncioVeiculo findById(Long id) {
		AnuncioVeiculo anuncioveiculo = this.anuncioveiculorepository.findById(id).get();
		return anuncioveiculo;
	}

	public List<AnuncioVeiculo> findByNomeVeiculoLike(String nomeVeiculo) {
		List<AnuncioVeiculo> anuncioveiculo = anuncioveiculorepository.findByNomeVeiculoLike(nomeVeiculo);
		return anuncioveiculo;
	}

}
