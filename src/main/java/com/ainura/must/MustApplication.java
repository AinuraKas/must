package com.ainura.must;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class MustApplication {

	public static void main(String[] args) {
		SpringApplication.run(MustApplication.class, args);
	}

	//eto dlya null v dannyh esli ispolzue6 mustache
	@Bean
	public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader,
											  Environment environment) {

		MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
		collector.setEnvironment(environment);

		// default value
		Mustache.Compiler compiler = Mustache.compiler().defaultValue("")
				.withLoader(mustacheTemplateLoader)
				.withCollector(collector);
		return compiler;

	}
}
