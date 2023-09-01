package com.jk.store.produto.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ProdutoModelService {
	
	public Produto addNovoProduto(Produto produto);
	
	public List<Produto> listarProdutos();
	
	public Produto buscarProdutoPorId(Long id);
	
	public Produto addFotoDoProduto(Long id, MultipartFile arquivo);


}
