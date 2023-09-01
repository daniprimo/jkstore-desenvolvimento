package com.jk.store.produto.infra.validacoes;

import org.springframework.stereotype.Component;

import com.jk.store.produto.model.Produto;

@Component
public interface validacao {
	
	public void validar(Produto produto);			

}
