package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Proposta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idProposta;
	
	@NotBlank
	private String DataCriado;
	@NotBlank
	private double ValorProposta;
	@NotBlank
	private String DescricaoProposta;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("proposta")
	private AnuncioVeiculo anuncioveiculo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("proposta")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "proposta")
	@JsonIgnoreProperties("proposta")
	private Proposta proposta;
}
