package com.jk.store.utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jk.store.utils.exceptions.handle.AplicacaoException;

public class Logs {
	
	private String classe;
	private static final Logger LOG = LoggerFactory.getLogger(AplicacaoException.class);


	public Logs(String classe) {
		this.classe = classe;
	}
	
	public void info(String menssage) {
		LOG.info(String.valueOf(classe).concat(menssage));
	}
	
	public void erro(String menssage) {
		LOG.error(String.valueOf(classe).concat(menssage));
	}


}
