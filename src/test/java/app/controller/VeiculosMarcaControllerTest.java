package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import app.entity.VeiculosMarca;
import app.repository.VeiculosMarcaRepository;

@SpringBootTest
public class VeiculosMarcaControllerTest {

	@Autowired
	VeiculosMarcaController veiculosmarcaController;
	
	@MockBean
	VeiculosMarcaRepository repository;
	
	
	
	@BeforeEach
	void setup() {
		
		List<VeiculosMarca> veiculosmarca = new ArrayList<>();
		veiculosmarca.add(new VeiculosMarca(1L, "HONDA", null));
		
		VeiculosMarca veiculosmarcaSalva = new VeiculosMarca(1L, "HONDA", null);
		
		when(this.repository.save(any(VeiculosMarca.class))).thenReturn(veiculosmarcaSalva);
		when(this.repository.findAll()).thenReturn(veiculosmarca);
		when(this.repository.findByMarca("HONDA")).thenReturn(veiculosmarcaSalva);
	}
	
	// ------------------------		Save	-----------------------------

		@Test
		@DisplayName("1 -[TESTE] Save")
		void save() {
			VeiculosMarca novoVeiculosMarca = new VeiculosMarca(1L, "HONDA", null);
			
			when(repository.save(any(VeiculosMarca.class))).thenReturn(novoVeiculosMarca);
			ResponseEntity<String> VeiculosMarcaSalva = veiculosmarcaController.save(novoVeiculosMarca);
			verify(repository, times(1)).save(novoVeiculosMarca);
			assertNotNull(VeiculosMarcaSalva);
			
		}
		
		@Test
		@DisplayName("1 -[Exception] Save")
		void save_Exception() {
			when(repository.save(any(VeiculosMarca.class))).thenThrow(new RuntimeException("Erro ao Salvar a Marca"));
			ResponseEntity<String> response = veiculosmarcaController.save(new VeiculosMarca(1L, "HONDA", null));
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		}
		
		//--------------------------	LIST ALL	-----------------------------------
		
		@Test
		@DisplayName("2 -[TESTE] findAll")
		void findall() {
			ResponseEntity<List<VeiculosMarca>> response = this.veiculosmarcaController.findAll();
			List<VeiculosMarca> veiculosmarcaAll = response.getBody();
			
			assertEquals(1, veiculosmarcaAll.size());
		}
		
		@Test
		@DisplayName("2 -[EXCEPTION] FindAll")
		void findall_exception() {
			when(this.repository.findAll()).thenThrow(new RuntimeException("Erro ao lista Marca"));
			ResponseEntity<List<VeiculosMarca>> response = this.veiculosmarcaController.findAll();
			assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
			assertNull(response.getBody());
		}
		
		//--------------------------------	DELETE 	-----------------------------------------
		
		@Test
		@DisplayName("3 -[TESTE] Delete")
		void delete() {
			ResponseEntity<String> response = this.veiculosmarcaController.delete(1L);
			assertEquals(HttpStatus.OK,response.getStatusCode());
		}
		
		@Test
		@DisplayName("3 -[EXCEPTION] Delete")
		void delete_exception() {
			when(veiculosmarcaController.delete(999L)).thenThrow(new RuntimeException("Erro ao deletar proposta"));
			ResponseEntity<String> response = veiculosmarcaController.delete(999L);
			assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		}
		
		
		//----------------------------		FindById		---------------------------------------
		
		@Test
		@DisplayName("4 -[TESTE] FindById")
		void FindById() {
			VeiculosMarca veiculosmarca = new VeiculosMarca();
			veiculosmarca.setIdMarca(1L);
			when(repository.findById(1L)).thenReturn(Optional.of(veiculosmarca));
			ResponseEntity<VeiculosMarca> response = veiculosmarcaController.findById(1L);
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertEquals(veiculosmarca,response.getBody());
		}
		
		@Test
		@DisplayName("[EXCEPTION] FindById")
		void findById_Exception() {
			when(repository.findById(999L)).thenThrow(new RuntimeException("Erro ao buscar venda"));
			ResponseEntity<VeiculosMarca> response = veiculosmarcaController.findById(999L);
			assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
			assertNull(response.getBody());
		}
		
		//----------------------------		UPDATE		---------------------------------------------
		
		@Test
		@DisplayName("[TESTE] Update")
		void update() {
			VeiculosMarca veiculosmarcaSalva = new VeiculosMarca(1L, "HONDA", null);
			ResponseEntity<String> response = this.veiculosmarcaController.update(1L, veiculosmarcaSalva);
			HttpStatusCode resposta = response.getStatusCode();
			assertEquals(HttpStatus.OK, resposta);
		}

		@Test
		@DisplayName("[EXCEPTION] Update")
		void update_exception() {
			when(this.repository.save(any(VeiculosMarca.class))).thenThrow(new RuntimeException("Erro ao Atualizar Marca"));
			ResponseEntity<String> response = this.veiculosmarcaController.update(1L, new VeiculosMarca(1L, "HONDA", null));
			assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
		}
		
		//----------------------------		FindByMarca		---------------------------------------
		
		@Test
		@DisplayName("[TESTE] FindByMarca")
		void findByMarca() {
			ResponseEntity <VeiculosMarca> response = this.veiculosmarcaController.findByMarca("HONDA");
			VeiculosMarca veiculosmarca = response.getBody();
			assertNotNull(veiculosmarca);
			assertEquals("HONDA", veiculosmarca.getMarca());
			assertEquals(HttpStatus.OK, response.getStatusCode());
		}
		
}
