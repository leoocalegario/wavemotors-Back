package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.AnuncioVeiculo;
import app.service.AnuncioVeiculoService;

@RestController
@RequestMapping("/api/anuncioveiculo")
@Validated
public class AnuncioVeiculoController {
	
	@Autowired
	private AnuncioVeiculoService anuncioveiculoservice;
	
	@PostMapping("save")
	public ResponseEntity<String> save (@RequestBody AnuncioVeiculo anuncioveiculo){
		try {
			String mensagem = this.anuncioveiculoservice.save(anuncioveiculo);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<String>("erro: " +e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{idAnuncio}")
	public ResponseEntity<String>update (@RequestBody AnuncioVeiculo anuncioveiculo, @PathVariable Long idAnuncio ){
		try {
			String mensagem = this.anuncioveiculoservice.update(idAnuncio, anuncioveiculo);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<AnuncioVeiculo>>listAll(){
		try {
			List<AnuncioVeiculo> lista = this.anuncioveiculoservice.listAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/findById/{idAnuncio}")
	public ResponseEntity<AnuncioVeiculo> findById(@PathVariable Long idAnuncio){
		try {
			AnuncioVeiculo anuncioveiculo = this.anuncioveiculoservice.findById(idAnuncio);
			return new ResponseEntity<>(anuncioveiculo,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{idAnuncio}")
	public ResponseEntity<String> delete(@PathVariable Long idAnuncio) {

		try {

			String mensagem = this.anuncioveiculoservice.delete(idAnuncio);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByNomeLike")
	public ResponseEntity<List<AnuncioVeiculo>> findByNomeVeiculoLike(@RequestParam String nomeveiculo) {
	    try {
	        List<AnuncioVeiculo> anuncioveiculo = this.anuncioveiculoservice.findByNomeVeiculoLike(nomeveiculo);
	        return new ResponseEntity<>(anuncioveiculo, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}


}