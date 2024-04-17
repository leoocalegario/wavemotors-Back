package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

public class Proposta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idProposta;
	
	@NotBlank
	private String dataCriado;
	@NotNull
	private double valorProposta;
	@NotBlank
	private String DescricaoProposta;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("proposta")
	private AnuncioVeiculo anuncioveiculo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("proposta")
	private Cliente cliente;

}
