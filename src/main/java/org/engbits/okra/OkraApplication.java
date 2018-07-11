package org.engbits.okra;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Primary entry point for the Okra Spring Boot application
 *
 * @author okra.team
 * @since 0.1.0
 */
@SpringBootApplication
@EntityScan("org.engbits.okra.model")
@EnableJpaRepositories
@Configuration
@PropertySources({
        @PropertySource("classpath:okra.properties"),
        @PropertySource(value = "file:${external.config}", ignoreResourceNotFound = true),
})
public class OkraApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OkraApplication.class);
    }

    public static void main(String[] args) {
        new OkraApplication()
                .configure(new SpringApplicationBuilder(OkraApplication.class))
                .run(args);
    }

}
