package io.seventytwo.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class XmlToCsvRoute extends RouteBuilder {

    private String from = "file://c:/var/input?fileName=demo.xml";
    private String to = "file://c:/var/output?fileName=${file:name}.csv";

    public XmlToCsvRoute() {
    }

    public XmlToCsvRoute(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void configure() throws Exception {
        from(from)
                .routeId("XmlToCsvRoute")
                .to("xslt:xslt/demo_csv.xslt")
                .to(to);
    }
}