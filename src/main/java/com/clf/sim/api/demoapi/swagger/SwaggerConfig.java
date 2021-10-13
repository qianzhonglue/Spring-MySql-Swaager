package com.clf.sim.api.demoapi.swagger;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
// import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.clf.sim.api.demoapi"))
                        .paths(PathSelectors.regex("/api/.*"))
                        .build()
                        .directModelSubstitute(Timestamp.class, Date.class);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resouces/webjars/");
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("GlucoMeter Api")
                .description("\"GlucoMeter Api\"")
                .version("1.0.3")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("cinderella quan", "http://springframework.guru/about/", "2513355854@qq.com"))
                .build();
    }
}
