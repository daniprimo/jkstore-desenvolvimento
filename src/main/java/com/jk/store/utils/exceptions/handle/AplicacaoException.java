package com.jk.store.utils.exceptions.handle;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.jk.store.utils.exceptions.ExceptionAoSalvarNoBancoDeDados;

import br.com.mambo.transporte.utils.exceptions.dto.DefaultError;
import br.com.mambo.transporte.utils.exceptions.dto.StandarError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AplicacaoException extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(AplicacaoException.class);
	
	
	@ExceptionHandler(ExceptionAoSalvarNoBancoDeDados.class)
	public ResponseEntity<StandarError> naoEncontradoNoBancoDeDados(ExceptionAoSalvarNoBancoDeDados e, HttpServletRequest request){
		LOG.error("Erro ao salvar objeto no banco de dados");
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Erro ao Salvar no Banco de dados.");
		err.setMessage(e.getMenssagem());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	
	
	


}
