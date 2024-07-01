package de.rjst.springintegrationneo4jimporter.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "integration-graph-service", url = "http://localhost:8080/actuator/integrationgraph", configuration = FeignConfig.class)
public interface IntegrationGraphService {

    @GetMapping
    IntegrationGraph getIntegrationGraph();

}
