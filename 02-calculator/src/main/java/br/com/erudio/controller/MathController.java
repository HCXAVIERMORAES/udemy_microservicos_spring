package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.numberConverter;

//adiciona-se um @RestController, para q o rest o reconheça como um controler
@RestController
public class MathController {
	//para instanciar a classe simpleMath
	private SimpleMath math = new SimpleMath();
		
	// soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		//fazendo a validação dos parametros - logica ou regra de negocio, usando a classe numberConverter e chamando o método isNumeric
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
		}
		//Passa-se o numero convertido e retorna o resultado
		return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo)); 		
	}
	
	//subtração
		@RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
		public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
			
			if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			return math.subtracao(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));			
		}
		
		//multiplicação
		@RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
		public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
			
			if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			
			return math.multiplicacao(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
		}
		
		//divisão
		@RequestMapping(value = "/divisao/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
		public Double divisao(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo) throws Exception {
			if(!numberConverter.isNumeric(numberOne)|| !numberConverter.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");				
			}
			
			return math.divisao(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));			
		}
		
		// media
		@RequestMapping(value = "/media/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
		public Double media(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo) throws Exception {
			if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			return math.media(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
		}
		
		//raiz quadrada
		@RequestMapping(value = "/raizQuadrada/{number}" , method = RequestMethod.GET)
		public Double raizQuadrada(@PathVariable("number") String number) throws Exception {
			if(!numberConverter.isNumeric(number)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			return math.raizQuadrada(numberConverter.convertToDouble(number));
		} 
		
		//potenciação
		@RequestMapping(value = "/potencia/{base}/{expoente}" , method = RequestMethod.GET)
		public Double potencia(@PathVariable("base") String base, @PathVariable("expoente") String expoente) throws Exception{
			if(!numberConverter.isNumeric(base) || !numberConverter.isNumeric(expoente)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			return math.potencia(numberConverter.convertToDouble(base), numberConverter.convertToDouble(expoente));
		}
	
}// fim classe MathController
