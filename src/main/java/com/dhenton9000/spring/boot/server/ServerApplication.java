package com.dhenton9000.spring.boot.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

public class ServerApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(CdnBoot.class);
        app.run(args);
    }
}



//allows using a nonstandard props file ie application.properties
@PropertySource(value={"classpath:init-boot.properties"}, ignoreResourceNotFound = true) 
@SpringBootApplication
@EnableSwagger2
        
class CdnBoot {

    private String serverPort;

    private static final Logger LOG = LoggerFactory.getLogger(ServerApplication.class);

    public CdnBoot(@Value("${server.port}") String s,@Value("${spring.freemarker.template-loader-path}") String fPath) {

        serverPort = s;
        LOG.info("starting server on port " + serverPort);
        LOG.info("freemark location "+fPath);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("props")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/props/.*"))
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage custom404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            container.addErrorPages(custom404Page);

        });
    }

    private ApiInfo apiInfo() {
        Contact c = new Contact("Don Henton", "http://donhenton.com", null);
        return new ApiInfoBuilder()
                .title("Demo Properties Sever")
                .description("Properties as a Service. This service will read an applications.properties file and present the contents.")
                //.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact(c)
                .license("Apache License Version 2.0")
                // .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("1.0")
                .build();
    }

}
