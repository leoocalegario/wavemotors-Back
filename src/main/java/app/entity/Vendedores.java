package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class Vendedores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVendedor;
	
	@NotBlank
	private String Senha;
	
	@Email
	private String email;
	
	@NotBlank
	private String Nome;
	
	@NotBlank
	private int idade;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
	
	@Column(name = "flag_User")
    @Basic
	private boolean flagTipoUser;
	
	@Column(name = "flag_ativo")
    @Basic
	private boolean flagAtivo;
	
	
	
}
