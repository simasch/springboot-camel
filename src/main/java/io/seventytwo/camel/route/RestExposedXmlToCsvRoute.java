package io.seventytwo.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestExposedXmlToCsvRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().contextPath("/camel");

        rest("/products").get().produces("text/csv").to("direct:products");

        from("direct:products")
                .pollEnrich("file://c:/var/input?fileName=products.xml&noop=true")
                .to("xslt:xslt/demo_csv.xslt");
    }
}
