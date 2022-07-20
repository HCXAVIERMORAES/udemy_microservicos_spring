package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//classe de excessoes q retorna sempre um Response status
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//implementa-se um construtor para a classe q recebe uma string, mensagem, de exception
	public UnsuportedMathOperationException(String exception) {
		//passa-s super recebendo a exception com parametro
		super(exception);
	}

}
