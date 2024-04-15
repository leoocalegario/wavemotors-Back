package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
	private long idAnuncio;
	
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
	private int combustivel;
	
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
	
	@Pattern(regexp = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$", message = "Placa inválida")
	@NotBlank
	private String PlacaCarro;
	
	@NotBlank
	private int Km;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JsonIgnoreProperties("anuncio_veiculo")
	private Vendedores vendedores;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("anuncio_veiculos")
	private VeiculosMarca veiculosmarca;
	
	@OneToMany(mappedBy = "anuncio_veiculo")
	@JsonIgnoreProperties("anuncio_veiculo")
	private Proposta proposta;
	
	
	
}
