package com.monkey.generator.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

    private static final String API_NAME = "luckgetmon API";
    @Value("${api.version}")
    private String API_VERSION;
    private static final String API_DESCRIPTION = "럭겟몬 API";
    @Value("${api.hosturl}")
    private String hosturl;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.host(hosturl)
        		.consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
        		.useDefaultResponseMessages(false)
//        		.securityContexts(Collections.singletonList(securityContext()))
//       		.securitySchemes(Collections.singletonList(apiKey()))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.monkey.generator.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
    	log.info(API_VERSION);
		return new ApiInfoBuilder()
			.title(API_NAME)
			.version(API_VERSION)
			.description(API_DESCRIPTION)
			.build();
    }
    
    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add(MediaType.APPLICATION_JSON_VALUE);
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add(MediaType.APPLICATION_JSON_VALUE);
        return produces;
    }
    
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", "Authorization", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//    }

//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
//    }
}