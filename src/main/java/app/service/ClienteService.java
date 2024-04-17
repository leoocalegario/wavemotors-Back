package app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import app.controller.List;
import app.entity.Cliente;
import app.repository.ClienteRepository;
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return "Cliente salvo com sucesso";
	}
	
	public String update(Cliente cliente, long id) {
		cliente.setIdUser(id);
		this.clienteRepository.save(cliente);
		return "Cliente Atualizado com sucesso";
	}
	
	public String delete(Long id) {
		this.clienteRepository.deleteById(id);
		return "Cliente Deletado com sucesso";
	}
	
	public List<Cliente> listAll() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		return cliente.get();
	}
	
	
	public List<Cliente> findbyNome(String nome) {
		List<Cliente> lista = clienteRepository.findByNomeLike(nome);
		return lista;
	}
	public List<Cliente> findByCidade(String cidade) {
		List<Cliente> lista = clienteRepository.findByCidade(cidade);
		return lista;
		
	}
	public List<Cliente> findByNomeLike(String nome) {
		List<Cliente> lista = clienteRepository.findByNomeLike(nome);
		return lista;
	}
	
	

	
	
}

