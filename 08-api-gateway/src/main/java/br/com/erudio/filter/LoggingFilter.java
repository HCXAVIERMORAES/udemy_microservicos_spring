package br.com.erudio.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	//definir o logger
			private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
			
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		//logger.info("Caminho original da requisição -> {}",exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
