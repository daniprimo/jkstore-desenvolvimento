package com.jk.store.produto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jk.store.Builder.ProdutoBuilder;

class ProdutoTest {
	
	private static final String NOME_PRODUTO = "Nike Air";
	private static final String DESCRICAO_PRODUTO = "Tennis Sport";
	private static final String PRECO_PRODUTO = "R$ 800,00";
	

	@Test
	void criandoObjetoProduto() {
		Produto produto = ProdutoBuilder.Builder()
								.nomeDoProduto(NOME_PRODUTO)
								.descricaoDoProduto(DESCRICAO_PRODUTO)
								.precoDoProduto(PRECO_PRODUTO)
								.build();
		
		assertEquals(1l, produto.getId());
		assertEquals(NOME_PRODUTO, produto.getNome());
		assertEquals(DESCRICAO_PRODUTO, produto.getDescricao());
		assertEquals(PRECO_PRODUTO, produto.getPreco());
	}

}
