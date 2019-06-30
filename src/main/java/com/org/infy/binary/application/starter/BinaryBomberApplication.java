package com.org.infy.binary.application.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.log4j.Logger;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.org.infy.binary"})
@EnableJpaRepositories( basePackages = "com.org.infy.binary")
@EntityScan("com.org.infy.binary.entity")
public class BinaryBomberApplication {
	private final static Logger log = Logger.getLogger(BinaryBomberApplication.class);
	
	public static void main(String[] args) {
		log.debug("Infy Binary Bomber Started...");
		SpringApplication.run(BinaryBomberApplication.class, args);
	}

}
