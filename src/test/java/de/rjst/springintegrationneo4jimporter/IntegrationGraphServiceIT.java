package de.rjst.springintegrationneo4jimporter;

import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraph;
import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraphService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class IntegrationGraphServiceIT {

    @Autowired
    private IntegrationGraphService integrationGraphService;

    @Test
    void getIntegrationGraph() {

        IntegrationGraph result = integrationGraphService.getIntegrationGraph();

        assertThat(result).isNotNull();

    }
}
