package br.com.apipessoa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "pessoa" )
public class Pessoa {
	
	@Id
	private Long id;
	private String nome;
	private String tipoIdentificador;
	private String identificadorCliente;
	
	
}
