package br.com.erudio.math;

public class SimpleMath {
	//*Classe que faz as operações matematicas da calculadora/

	// metodo de soma
	public Double sum(Double fristNumber, Double secondNumber) {
		return fristNumber + secondNumber;

	}

	// metodo de subtração
	public Double subtracao(Double fristNumber, Double secondNumber) {
		return fristNumber - secondNumber;

	}

	// metodo de multiplicação
	public Double multiplicacao(Double fristNumber, Double secondNumber) {
		return fristNumber * secondNumber;

	}

	// método de divisão
	public Double divisao(Double fristNumber, Double secondNumber) {
		return fristNumber / secondNumber;

	}

	// metodo de media
	public Double media(Double fristNumber, Double secondNumber) {
		return (fristNumber + secondNumber) / 2;
	}

	// metodo da raiz quadrada
	public Double raizQuadrada(Double number) {
		return (Double) Math.sqrt(number);
	}
	
	//metodo de potencia
		public Double potencia(Double fristNumber, Double secondNumber) {
			return (Double) Math.pow(fristNumber,secondNumber);
		}
		
		

}
