package com.br.JSCustomer;

import com.br.JSCustomer.rest.api.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JsCustomerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JsCustomerApplication.class, args);
	}

}
