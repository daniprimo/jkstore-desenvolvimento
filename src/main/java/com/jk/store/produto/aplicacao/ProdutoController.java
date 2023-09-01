package com.jk.store.produto.aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jk.store.produto.model.Produto;
import com.jk.store.produto.model.ProdutoModelService;
import com.jk.store.produto.model.dto.ProdutoDTO;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	private ProdutoModelService service;
	
	@PostMapping
	@Operation(summary = "Adicionar novos produtos")
	public ResponseEntity<Produto> novoProduto(@RequestBody ProdutoDTO dto){
		Produto produto = new Produto(dto);
		Produto produtoSalvo = service.addNovoProduto(produto);	
		return ResponseEntity.ok(produtoSalvo);
	}
	
	@PostMapping("/arquivo/{id}")
	@Operation(summary = "Adicionar foto no produto")
	public ResponseEntity<Produto> novoProduto(@PathVariable Long id, @RequestParam("file") MultipartFile arquivo){
		Produto produtoSalvo = service.addFotoDoProduto(id, arquivo);
		return ResponseEntity.ok(produtoSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarTodosOsProdutos(){
		return ResponseEntity.ok(service.listarProdutos());
	}

	
}
