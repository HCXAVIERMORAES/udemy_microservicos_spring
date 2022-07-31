package br.com.erudio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

//mapeando o banco 
@Entity(name = "cambio")
public class Cambio implements Serializable{
	//serializer
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para saber q é auto-incremental
	private Long id;
	
	@Column(name = "from_currency", nullable = false, length = 3 ) //nomeando a coluna e definindo os parametros dela segundo o DB
	private String from; //de
	@Column(name = "to_currency", nullable = false, length = 3 )
	private String to; //para
	
	@Column(nullable = false) //definindo para que nunca seja nulo
	private BigDecimal conversionFactor; //fator de conversão
	
	@Transient //informa ao hibernet, jpa, etc que esse atributo nao será persisdido no banco
	private BigDecimal convertedValue; //valor de conversao
	@Transient
	private String environment; //porta de resposta
	
	//construtor vazio
	public Cambio() {}

	//construtor com atributos
	public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue,
			String environment) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.convertedValue = convertedValue;
		this.environment = environment;
	}
	
	//gets e sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversionFactor, convertedValue, environment, from, id, to);
	}	

	//eguals e hascod
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		return Objects.equals(conversionFactor, other.conversionFactor)
				&& Objects.equals(convertedValue, other.convertedValue)
				&& Objects.equals(environment, other.environment) && Objects.equals(from, other.from)
				&& Objects.equals(id, other.id) && Objects.equals(to, other.to);
	}
	
	
	

}
