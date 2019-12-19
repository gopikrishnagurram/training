package com.wavelabs.SpringExceptionHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wavelabs.repository.StudentRepository;

@SpringBootApplication
@ComponentScan(basePackages ={"com.wavelabs","com.wavelabs.repository","com.wavelabs.bean"})
@EnableJpaRepositories(basePackageClasses={StudentRepository.class})
@EntityScan("com.wavelabs")
@EnableTransactionManagement
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
}
