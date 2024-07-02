package de.rjst.springintegrationneo4jimporter;

import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraph;
import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraphService;
import de.rjst.springintegrationneo4jimporter.adapter.LinksItem;
import de.rjst.springintegrationneo4jimporter.adapter.NodesItem;
import de.rjst.springintegrationneo4jimporter.database.IntegrationObject;
import de.rjst.springintegrationneo4jimporter.database.IntegrationObjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
@Component
public class Importer implements CommandLineRunner {

    private final IntegrationObjectRepository integrationObjectRepository;
    private final IntegrationGraphService integrationGraphService;
    private final Function<NodesItem, IntegrationObject> integrationObjectMapper;

    @Override
    public void run(final String... args) {
        integrationObjectRepository.deleteAll();

        final Map<Integer, IntegrationObject> nodeMap = new HashMap<>();
        final IntegrationGraph integrationGraph = integrationGraphService.getIntegrationGraph();
        for (final NodesItem node : integrationGraph.getNodes()) {
            final IntegrationObject integrationObject = integrationObjectMapper.apply(node);
            nodeMap.put(node.getNodeId(), integrationObject);
            log.info("Node: {}", integrationObject.getNodeId());
        }

        for (final LinksItem links : integrationGraph.getLinks()) {
            final IntegrationObject source = nodeMap.get(links.getFrom());
            final IntegrationObject target = nodeMap.get(links.getTo());
            switch (links.getType()) {
                case "input" -> source.getInputObjects().add(target);
                case "output" -> source.getOutputObjects().add(target);
                case "route" -> source.getRouteObjects().add(target);
                case "discard" -> source.getRouteObjects().add(target);
                default -> log.error("Unknown link type: {}", links.getType());
            }
            log.info("Link: {} -> {}", source.getNodeId(), target.getNodeId());
        }

        integrationObjectRepository.saveAll(nodeMap.values());
    }

}
