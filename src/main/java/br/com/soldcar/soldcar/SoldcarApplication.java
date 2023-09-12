package br.com.soldcar.soldcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.soldcar.soldcar.model")
public class SoldcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoldcarApplication.class, args);
	}

}
