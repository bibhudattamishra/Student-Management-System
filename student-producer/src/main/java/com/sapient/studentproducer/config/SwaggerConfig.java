package com.sapient.studentproducer.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/student-api/v1/students.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student Management API").description("Student Management Spring Boot API reference for developers")
				.termsOfServiceUrl("https://www.sapientglobalmarkets.com/terms").contact("bibhudatta.mishra@sapient.com").license("Sapient Global Market License")
				.licenseUrl("https://www.sapientglobalmarkets.com/").version("1.0").build();
	}

}
