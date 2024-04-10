package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
