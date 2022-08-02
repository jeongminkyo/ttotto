package com.landvibe.ttotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TtottoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtottoApplication.class, args);
	}

}
