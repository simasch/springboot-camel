package io.seventytwo.camel.route;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XmlToCsvRouteTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:out")
    private MockEndpoint mockOut;

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new XmlToCsvRoute("direct:in", "mock:out");
    }


    @Test
    public void transformXmlToCsv() throws InterruptedException {
        mockOut.expectedBodiesReceived("1234,Snickers\r\n");

        template.sendBody("direct:in", "<products><product nr=\"1234\"><name>Snickers</name></product></products>");

        assertMockEndpointsSatisfied();
    }

}