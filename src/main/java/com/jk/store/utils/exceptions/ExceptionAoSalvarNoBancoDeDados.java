package com.jk.store.utils.exceptions;

import com.jk.store.utils.exceptions.handle.JkStoreExceptions;


public class ExceptionAoSalvarNoBancoDeDados extends JkStoreExceptions {

	private static final long serialVersionUID = 1L;

	public ExceptionAoSalvarNoBancoDeDados(String menssagem) {
		super(menssagem);
	}


}
