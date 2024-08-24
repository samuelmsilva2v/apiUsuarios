package com.example.demo.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.JwtBearerFilter;

@Configuration
public class JwtBearerConfig {

	@Bean
	FilterRegistrationBean<JwtBearerFilter> jwtFilter() {

		/*
		 * registrando o filtro que irá validar
		 * os TOKENS JWT nos ENDPOINTS
		 */
		FilterRegistrationBean<JwtBearerFilter> filter = new FilterRegistrationBean<JwtBearerFilter>();
		filter.setFilter(new JwtBearerFilter());

		/*
		 * mapear os ENDPOINTS da API que deverão exigir
		 * o TOKEN de autorização
		 */
		filter.addUrlPatterns("/api/usuario/obter-dados");
		return filter;
	}

}
