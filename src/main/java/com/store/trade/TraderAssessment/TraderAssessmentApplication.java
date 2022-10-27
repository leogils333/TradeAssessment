package com.store.trade.TraderAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan("com.store.trade.web")
@SpringBootApplication
@EnableJpaRepositories("com.store.trade.web.dao")
@EntityScan("com.store.trade.web.model")
public class TraderAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraderAssessmentApplication.class, args);
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "Index";
	}

}
