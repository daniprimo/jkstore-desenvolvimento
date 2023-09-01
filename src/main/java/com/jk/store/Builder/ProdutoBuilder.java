package com.jk.store.Builder;

import com.jk.store.produto.model.Produto;

public class ProdutoBuilder {
	
	private Produto produto;
	
	private ProdutoBuilder() {}
	
	public static ProdutoBuilder Builder() {
		ProdutoBuilder builder = new ProdutoBuilder();
		builder.produto = new Produto();
		builder.produto.setId(1l);
		builder.produto.setCategoria("Tennis");
		builder.produto.setPathFoto("caminho do arquivo");
		return builder;
	}
	
	public ProdutoBuilder nomeDoProduto(String nome) {
		produto.setNome(nome);
		return this;
	}
	
	public ProdutoBuilder descricaoDoProduto(String descricao) {
		produto.setDescricao(descricao);
		return this;
	}
	
	public ProdutoBuilder precoDoProduto(String preco) {
		produto.setPreco(preco);
		return this;
	}
	
	
	public Produto build() {
		return produto;
	}
	
	

}
