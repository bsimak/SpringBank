package org.example.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.TransactionService;
import org.example.ApplicationLauncher;
import org.springframework.context.annotation.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource(value = "classpath:/application.properties")

public class ApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
