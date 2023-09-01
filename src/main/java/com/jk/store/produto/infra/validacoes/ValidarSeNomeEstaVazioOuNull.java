package com.jk.store.produto.infra.validacoes;

import org.springframework.stereotype.Component;

import com.jk.store.produto.model.Produto;

@Component
public class ValidarSeNomeEstaVazioOuNull implements validacao{

	@Override
	public void validar(Produto produto) {
		if (produto.getNome() == "" || produto.getNome() == null) {
			throw new RuntimeException("Nome vazio");
		}
	}

}
