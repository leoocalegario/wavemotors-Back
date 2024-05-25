package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	public String save(Acessorio acessorio) {
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome()+ "Salvo com sucesso";
	}
	
	public String update(long id, Acessorio acessorio) {
		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome() + "Atualizado com Sucesso";
	}
	
	public List<Acessorio> listAll(){
		return this.acessorioRepository.findAll();
	}
	
	public Acessorio findById(long id) {
		Acessorio acessorio = this.acessorioRepository.findById(id).get();
		return acessorio;
	}
	
	public String delete(long id) {
		this.acessorioRepository.deleteById(id);
		return "Acessorio Deletado";
	}
}
