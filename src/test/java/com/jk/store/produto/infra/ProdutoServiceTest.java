package com.jk.store.produto.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jk.store.Builder.ProdutoBuilder;
import com.jk.store.produto.model.Produto;
import com.jk.store.produto.model.ProdutoRepository;


@SpringBootTest
class ProdutoServiceTest {
	
	private Produto produtoRetorno;
	
	@Autowired
	private ProdutoService produtoService;
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	private static final String NOME_PRODUTO = "Nike Air";
	private static final String DESCRICAO_PRODUTO = "Tennis Sport";
	private static final String PRECO_PRODUTO = "R$ 800,00";

	
	@BeforeEach
	void instancias() {
		produtoRetorno = ProdutoBuilder.Builder()
					.nomeDoProduto(NOME_PRODUTO)
					.descricaoDoProduto(DESCRICAO_PRODUTO)
					.precoDoProduto(PRECO_PRODUTO)
					.build();
	}
	

	@Test
	@DisplayName("Teste salvar produto no banco de dados")
	void salvarProdutoNoBancoDeDados() {	
		
		when(produtoRepository.save(produtoRetorno))
			.thenReturn(produtoRetorno);
		
		assertEquals(produtoRetorno, produtoService.addNovoProduto(produtoRetorno));
	}
	
	

}
