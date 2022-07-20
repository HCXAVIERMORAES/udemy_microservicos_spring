package br.com.erudio.request.converters;

public class numberConverter {
	/*os metodos foram criados de forma staticos (static) pois assim não seria necessario instancias a classe numberConverter
	 * ao chamar esses metodos
	*/
	
	//metodo de conversão de string para Doublo	
		public static Double convertToDouble(String strNumber) {
			if(strNumber == null) return 0d;
			String number = strNumber.replaceAll("," , ".");//altera as vigulas por pontos
			if(isNumeric(number)) return Double.parseDouble(number);//verifca  se é um numero e retorna um double
			return 0d;
		}

		//metodo para verificar se são numeros
		public static boolean isNumeric(String strNumber) {
			if(strNumber == null) return false;
			String number = strNumber.replaceAll("," , ".");//altera as vigulas por pontos
			return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //verifica se a regex é um numero 
		}
}
