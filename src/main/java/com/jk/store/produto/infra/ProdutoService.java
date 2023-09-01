package com.jk.store.produto.infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jk.store.produto.infra.validacoes.validacao;
import com.jk.store.produto.model.Produto;
import com.jk.store.produto.model.ProdutoModelService;
import com.jk.store.produto.model.ProdutoRepository;
import com.jk.store.utils.exceptions.ExceptionAoSalvarNoBancoDeDados;
import com.jk.store.utils.log.Logs;

@Service
public class ProdutoService implements ProdutoModelService{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private List<validacao> validadores;

	
	private static final String NOME_CLASSE = "Produto Service - ";
	
	private Logs LOG = new Logs(NOME_CLASSE);
	
	private static String caminhoDasFotos = "C:/Users/Daniel Lopes/Documents/photos/";

	
	
	@Override
	public Produto addNovoProduto(Produto produto) {
		LOG.info("Adicionar novo produto");		
		Produto produtoValidado = validarProdutor(produto);
		Produto produtoSalvo = salvarProduto(produtoValidado);
		return produtoSalvo;
	}
	
	@Override
	public List<Produto> listarProdutos() {
		LOG.info("Listar todos os produtos");
		return produtoRepository.findAll();
	}
	

	@Override
	public Produto buscarProdutoPorId(Long id) {
		LOG.info("Encontra produtos por id: "+id);
		return produtoRepository.findById(id).get();
	}
	
	@Override
	public Produto addFotoDoProduto(Long id, MultipartFile arquivo) {
			LOG.info("Adicionar foto ao produto.");
		 	Produto produto = 	buscarProdutoPorId(id);
			produto = tratandoErroSalvarArquivo(arquivo, produto);
			Produto produtoSalvo = addNovoProduto(produto);
			LOG.info("Produto atualizado com a foto adicionada");
			return produtoSalvo;
	}

	private Produto tratandoErroSalvarArquivo(MultipartFile arquivo, Produto produto) {
		try {
			produto = salvarArquivo(arquivo, produto);
			LOG.info("Salvando foto no produto");
			return produto;
		} catch (IOException e) {
			LOG.erro("Erro pois arquivo não é valido.");
			throw new ExceptionAoSalvarNoBancoDeDados("Foto não foi salva por erro no arquivo. "+ e.getMessage());
		} catch (RuntimeException e) {
			LOG.erro("Erro pois arquivo está vazio");
			throw new ExceptionAoSalvarNoBancoDeDados("Foto não foi salva por erro no arquivo. "+ e.getMessage());
		}
	}

	private Produto salvarArquivo(MultipartFile arquivo, Produto produto) throws IOException {
		LOG.info("Salvando foto no produto");
		if (!arquivo.isEmpty()) {
			byte [] bytes = arquivo.getBytes();
			Path caminho = Paths.get(caminhoDasFotos+
					String.valueOf(produto.getNome())+
					arquivo.getOriginalFilename());
			Files.write(caminho, bytes);
			
			produto.setPathFoto(String.valueOf(produto.getId())+arquivo.getOriginalFilename());
		
		}else {
			throw new RuntimeException("Arquvio vazio.");
		}
		return produto;
	}
	
	private Produto salvarProduto(Produto produtoValidado) {
		try {
			Produto produtoSalvo = produtoRepository.save(produtoValidado);
			LOG.info("Produto Salvo");
			return produtoSalvo;			
		}catch (Exception e) {
			LOG.erro("Erro ao salvar produto");
			throw new ExceptionAoSalvarNoBancoDeDados("Produto já existente");
		}
	}

	public Produto validarProdutor(Produto produto) {
	/*	List<validacao> validadores = Arrays.asList(new ValidarSeNomeEstaVazioOuNull(),
				new ValidarSeValorEstaVazio());*/
		try {
			produto.validacao(validadores);
			LOG.info("Produto validado");
			return produto;			
		}catch (RuntimeException e) {
			LOG.erro("Produto invalido, motivo: " + e.getMessage());				
			throw new ExceptionAoSalvarNoBancoDeDados("Produto invalido, motivo: " + e.getMessage());
		}
	}

	



	
	
	
	
	
}
