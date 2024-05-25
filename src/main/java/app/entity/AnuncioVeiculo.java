	package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnuncioVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnuncio;

	@NotBlank
	private String cor;
	
	@NotBlank
	private String imagem;

	@NotBlank
	private String modelo;

	@NotNull
	private int ano;

	@NotNull
	private String combustivel;

	@NotNull
	private double valorcarro;

	//@Pattern(regexp = "^'", message = "Placa inválida")
	@NotBlank
	private String placacarro;

	@NotNull
	private int km;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("anuncioveiculo")
	private Vendedores vendedores;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("anuncioveiculo")
	private VeiculosMarca veiculosmarca;

	@OneToMany(mappedBy = "anuncioveiculo")
	@JsonIgnoreProperties("anuncioveiculo")
	private List<Proposta> proposta;
	
	@ManyToMany
	@JoinTable(name="carro_acessorio")
	private List<Acessorio> acessorios;

}
