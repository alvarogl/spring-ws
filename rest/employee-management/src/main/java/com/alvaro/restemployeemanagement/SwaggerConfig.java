package com.alvaro.restemployeemanagement;

import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final Contact SUPPORT_CONTACT = new Contact("Alvaro", "Localhost",
        "alvaro.gutierrez@test.com");

    @Bean
    public Docket newApi() {
        Set<String> produces = Set.of("application/json", "application/xml");
        Set<String> consumes = Set.of("application/json", "application/xml");
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).produces(produces)
            .consumes(consumes);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
            .description("REST API for Employee Management")
            .contact(SUPPORT_CONTACT)
            .termsOfServiceUrl("http://localhost:8080/tos")
            .version("1.0").build();
    }
}
