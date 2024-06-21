package de.rjst.springintegrationneo4jimporter.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "integration-graph-service", url = "https://rjst-integration.vpn.rjst.de/actuator/integrationgraph", configuration = FeignConfig.class)
public interface IntegrationGraphService {

    @GetMapping
    IntegrationGraph getIntegrationGraph();

}
