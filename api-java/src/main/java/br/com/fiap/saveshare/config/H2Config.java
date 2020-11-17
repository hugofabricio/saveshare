package br.com.fiap.saveshare.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fiap.saveshare.services.DBService;

@Configuration
@Profile("h2")
public class H2Config {
	
	@Autowired
	DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {//boolean por que o retorno neste caso não pode ser void
		dbService.instantiateTestDataBase();
		return true;
	}
	
}
