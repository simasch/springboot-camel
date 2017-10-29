package io.seventytwo.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestExposedHelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/camel")
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");

        rest("/hello")
                .get()
                .to("direct:hello");

        from("direct:hello")
                .routeId("RestExposedHelloRoute")
                .transform().constant("Hello World");
    }
}
