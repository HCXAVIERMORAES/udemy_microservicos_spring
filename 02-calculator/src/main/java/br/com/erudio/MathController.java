package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

//adiciona-se um @RestController, para q o rest o reconheça como um controler
@RestController
public class MathController {
		
	//metodo de soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		//fazendo a validação dos parametros - logica ou regra de negocio
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
		}
		//fazendo a soma - metodo
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
		
	}
	
	//metodo de subtração
		@RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
		public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
			
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
			return sum;			
		}
		
		//metodo de multiplicação
		@RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
		public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
			
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
			return sum;
		}
		
		//método de divisão
		@RequestMapping(value = "/divisao/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
		public Double divisao(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo) throws Exception {
			if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");				
			}
			
			Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
			return sum;			
		}
		
		//metodo de media
		@RequestMapping(value = "/media/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
		public Double media(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo) throws Exception {
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
			return sum;
		}
		
		//metodo da raiz quadrada
		@RequestMapping(value = "/raizQuadrada/{numberOne}" , method = RequestMethod.GET)
		public Double raizQuadrada(@PathVariable("numberOne") String numberOne) throws Exception {
			if(!isNumeric(numberOne)) {
				throw new UnsuportedMathOperationException("Por favor defina um valor numerico");
			}
			
			Double sum = (Double) Math.sqrt(convertToDouble(numberOne));
			return sum;
		}
		
		
	//metodo de conversão de string para Doublo	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll("," , ".");//altera as vigulas por pontos
		if(isNumeric(number)) return Double.parseDouble(number);//verifca  se é um numero e retorna um double
		return 0D;
	}

	//metodo para verificar se são numeros
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll("," , ".");//altera as vigulas por pontos
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //verifica se a regex é um numero 
	}

}
