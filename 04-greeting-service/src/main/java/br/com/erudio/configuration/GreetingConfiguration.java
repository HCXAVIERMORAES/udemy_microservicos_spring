package br.com.erudio.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

//chamando as configuações do arquivo criado em application.yml, com as anotações de configurationPropertis e component
//@RefreshScope - permite fazer atualizações  das configurações sem interomper o serviço.
@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {

	//atributos do arquivo
	private String greeting;
	private String defaultValue;
	               
	//construtor
	public GreetingConfiguration() {
		
	}
	
	//sets e gets
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
	
	
	
	
	
	
	
	
	
}
