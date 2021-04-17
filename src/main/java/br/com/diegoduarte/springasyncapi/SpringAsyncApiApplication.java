package br.com.diegoduarte.springasyncapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringAsyncApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAsyncApiApplication.class, args);
	}

}
