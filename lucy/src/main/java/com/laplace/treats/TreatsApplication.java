package com.laplace.treats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TreatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreatsApplication.class, args);
	}

}
