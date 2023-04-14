package com.rduttaassesment.inventaryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.rduttaassesment.inventaryservice.model.Inventary;
import com.rduttaassesment.inventaryservice.repository.InventaryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaryServiceApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner loadData(InventaryRepository inventaryRep){
		return args -> {
			Inventary inventary = new Inventary();
			inventary.setSkuCode("Iphone 13");
			inventary.setQuantity(100);


			Inventary inventary1 = new Inventary();
			inventary1.setSkuCode("Iphone 14");
			inventary1.setQuantity(0);


			inventaryRep.save(inventary);
			inventaryRep.save(inventary1);
		};
	}

}
