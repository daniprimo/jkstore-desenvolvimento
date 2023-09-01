package com.jk.store.produto.model;

import java.util.List;

import com.jk.store.produto.infra.validacoes.validacao;
import com.jk.store.produto.model.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = true)
	private String nome;
	private String descricao;
	private String categoria;
	private String preco;
	private String pathFoto;

		
	public void validacao(List<validacao> validacao){
	  validacao.forEach(produto -> produto.validar(this));
	}


	public Produto(ProdutoDTO dto) {
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.categoria = dto.getCategoria();
		this.preco = dto.getPreco();
	}
	
	

}
