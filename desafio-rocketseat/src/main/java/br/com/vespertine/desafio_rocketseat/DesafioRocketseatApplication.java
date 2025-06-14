package br.com.vespertine.desafio_rocketseat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DesafioRocketseatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioRocketseatApplication.class, args);
	}

}
