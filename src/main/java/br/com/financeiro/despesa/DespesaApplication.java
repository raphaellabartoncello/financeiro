package br.com.financeiro.despesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Configuration
@ComponentScan
public class DespesaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DespesaApplication.class, args);
	}

}
