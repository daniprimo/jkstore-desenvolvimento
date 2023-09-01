package com.jk.store.produto.infra.validacoes;

import org.springframework.stereotype.Component;

import com.jk.store.produto.model.Produto;

@Component
public class ValidarSeValorEstaVazio implements validacao {

	
	@Override
	public void validar(Produto produto) {
		if (produto.getPreco() == "" || produto.getPreco() == null) {
			throw new RuntimeException("Preco vazio");
		}
	}

}
