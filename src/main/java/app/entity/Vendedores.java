package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class Vendedores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVendedor;

	@NotBlank
	private String Senha;

	@Email
	private String email;

	@NotBlank
	private String nome;

	@Min(value = 18, message = "A pessoa deve ter pelo menos 18 anos de idade")
	@Max(value = 120, message = "A pessoa não pode ter mais de 120 anos de idade")
	@NotNull
	private int idade;

	@NotBlank
	private String endereco;

	@NotBlank
	private String cidade;

	@NotBlank
	private String estado;

	@Column(name = "flag_User") //flag para distincao de vendedor e admin
	private int flagTipoUser;

	@Column(name = "flag_ativo") //flag para distincao de usuario ativo e desativado
	@Basic
	private boolean flagAtivo;

	@OneToMany(mappedBy = "vendedores") //relacao de cardialidade one to many
	@JsonIgnoreProperties("vendedores")
	private List<AnuncioVeiculo> anuncioveiculo;

}
