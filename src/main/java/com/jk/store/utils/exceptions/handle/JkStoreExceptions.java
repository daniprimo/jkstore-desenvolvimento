package com.jk.store.utils.exceptions.handle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JkStoreExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String menssagem;
	
	public JkStoreExceptions(String menssagem) {
		this.menssagem = menssagem;
	}
	
	

}
