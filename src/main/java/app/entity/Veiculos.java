package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
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
public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCarro;
	
	@NotBlank
	private String data;
	
	@NotBlank
	private String NomeVeiculo;
	
	@NotBlank
	private String Cor;
	
	@NotBlank
	private String Modelo;
	
	@NotBlank
	private int ano;
	
	@NotBlank
	private String combustivel;
	
	@Column(name = "flag_Ar")
    @Basic
	private boolean FlagArCondicionado;
	
	@Column(name = "flag_BancoTipo")
    @Basic
	private boolean FlagBancoCouro;
	
	@Column(name = "flag_Multimidia")
    @Basic
	private boolean FlagMultimidia;
	
	@NotBlank
	private String TipoCambio;
	
	@NotBlank
	private double ValorCarro;
	
	@NotBlank
	private String PlacaCarro;
	
	@NotBlank
	private int Km;
	
	
}
