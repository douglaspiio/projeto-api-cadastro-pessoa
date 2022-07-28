package br.com.apipessoa.apipessoa.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apipessoa.apipessoa.model.Pessoa;
import br.com.apipessoa.apipessoa.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	@Transactional
	@RequestMapping("/cadastro")
	public void cadastroPessoa(@RequestBody Pessoa pessoa) {
		try {
			pessoaService.cadastro(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	@RequestMapping("/pessoas")
	public List<Pessoa> buscaPessoas() {
		return pessoaService.buscaTodos();
	}
}
