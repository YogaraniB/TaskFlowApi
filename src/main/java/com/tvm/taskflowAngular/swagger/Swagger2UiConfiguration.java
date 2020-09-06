package com.tvm.taskflowAngular.swagger;



import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition(securityDefinition = @SecurityDefinition(apiKeyAuthDefinitions = {@ApiKeyAuthDefinition(key = "X-Auth-Token",
in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER, name = "X-Auth-Token")}))
public class Swagger2UiConfiguration extends WebMvcConfigurerAdapter  {
	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				//.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/swagger2-demo"))
				.build()
				.securitySchemes(Arrays.asList(apikey1()));
		// @formatter:on
	}
	private ApiKey apikey() {
		return new ApiKey("apikey", "Authorization", "header");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TASKFLOW")
				.description("TASKFLOW PROJECT API reference for developers")
				.termsOfServiceUrl("http://helloWorld.com")
				.contact("helloworld@gmail.com").license("HelloWorld License")
				.licenseUrl("helloworld@gmail.com").version("1.0").build();
	}
	private ApiKey apikey1() {
		return new ApiKey("jwtToken", "Authorization", "header");
	}
	
}
