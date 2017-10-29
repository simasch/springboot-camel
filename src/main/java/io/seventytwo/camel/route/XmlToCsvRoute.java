package io.seventytwo.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class XmlToCsvRoute extends RouteBuilder {

    private String from = "file://var/input";
    private String to = "file://var/output";

    public XmlToCsvRoute() {
    }

    public XmlToCsvRoute(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void configure() throws Exception {
        from(from)
                .to("xslt:xslt/demo_csv.xslt")
                .to(to);
    }
}