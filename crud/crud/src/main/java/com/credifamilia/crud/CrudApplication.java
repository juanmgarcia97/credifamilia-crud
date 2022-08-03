package com.credifamilia.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.credifamilia.crud.controller.ClientController;

@SpringBootApplication
//@ComponentScan({"com.credifamilia.crud.controller", "com.credifamilia.crud.service", "com.credifamilia.crud.repository"})
//@ComponentScan(basePackageClasses = ClientController.class)
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
