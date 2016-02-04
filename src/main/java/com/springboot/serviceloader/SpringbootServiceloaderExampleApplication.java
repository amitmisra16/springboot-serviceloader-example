package com.springboot.serviceloader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.serviceloader.service.Dictionary;
import com.springboot.serviceloader.service.impl.DictionaryService;

@SpringBootApplication
public class SpringbootServiceloaderExampleApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringbootServiceloaderExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceloaderExampleApplication.class, args);
	}

	@Bean
	public ServiceListFactoryBean dictionaryServiceListFactoryBean() {
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
		serviceListFactoryBean.setServiceType(Dictionary.class);
		return serviceListFactoryBean;
	}

	@Autowired
	DictionaryService dictionaryService;

	@Override
	public void run(final String... strings) throws Exception {
		for(String word:strings) {
			log.info(String.format("%s : %s", word, dictionaryService.getDefinition(word)));
		}
	}
}
