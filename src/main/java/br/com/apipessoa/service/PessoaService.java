package br.com.apipessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apipessoa.model.Pessoa;
import br.com.apipessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public void cadastro(Pessoa pessoa) {
		verificaTipoIdentificador(pessoa);
		pessoaRepository.save(pessoa);
	}

	private void verificaTipoIdentificador(Pessoa pessoa) {
		if (pessoa.getIdentificadorCliente().length() <= 11) {
			pessoa.setTipoIdentificador("CPF");
		}else if (pessoa.getIdentificadorCliente().length() >= 14) {
			pessoa.setTipoIdentificador("CNPJ");
		}
		
	}

	public List<Pessoa> buscaTodos() {
		return pessoaRepository.findAll();
	}

}
