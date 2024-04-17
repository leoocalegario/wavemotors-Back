package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@Validated
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente cliente) {

		try {
			System.out.println(cliente.getNome());

			String mensagem = this.clienteService.save(cliente);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Foi encontrado um erro!", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		try {
			String mensagem = this.clienteService.update(id, cliente);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/delete/{idUser}")
	public ResponseEntity<String> delete(@PathVariable Long idUser) {
		try {
			String mensagem = this.clienteService.delete(idUser);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu esse erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> findAll() {
		try {
			List<Cliente> cliente = this.clienteService.findAll();
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{idUser}")
	public ResponseEntity<Cliente> findById(@PathVariable Long idUser) {
		try {
			Cliente cliente = this.clienteService.findById(idUser);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNome")
	public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome) {
		try {
			List<Cliente> lista = this.clienteService.findbyNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByCidade")
	public ResponseEntity<List<Cliente>> findByCidade(String cidade) {
		try {
			List<Cliente> lista = this.clienteService.findByCidade(cidade);

			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNomeLike")
	public ResponseEntity<List<Cliente>> findByNomeLike(@RequestParam String nome) {
		try {
			List<Cliente> lista = this.clienteService.findByNomeLike(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
