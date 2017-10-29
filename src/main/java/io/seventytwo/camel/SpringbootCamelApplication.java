package io.seventytwo.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCamelApplication.class, args);
    }

}
