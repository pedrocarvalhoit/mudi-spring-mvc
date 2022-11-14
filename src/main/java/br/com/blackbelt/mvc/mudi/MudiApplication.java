package br.com.blackbelt.mvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MudiApplication {

	//FALTANTE
	/**Salvar os acessos no banco de dados
	 * Enviar e salvar solicitações */
	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

}
