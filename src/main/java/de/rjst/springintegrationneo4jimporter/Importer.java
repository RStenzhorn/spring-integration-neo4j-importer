package de.rjst.springintegrationneo4jimporter;

import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraph;
import de.rjst.springintegrationneo4jimporter.adapter.IntegrationGraphService;
import de.rjst.springintegrationneo4jimporter.adapter.LinksItem;
import de.rjst.springintegrationneo4jimporter.adapter.NodesItem;
import de.rjst.springintegrationneo4jimporter.database.IntegrationObject;
import de.rjst.springintegrationneo4jimporter.database.IntegrationObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
@Component
public class Importer implements CommandLineRunner {

    private final IntegrationObjectRepository integrationObjectRepository;
    private final IntegrationGraphService integrationGraphService;
    private final Function<NodesItem, IntegrationObject> integrationObjectMapper;

    @Override
    public void run(final String... args) throws Exception {
        integrationObjectRepository.deleteAll();

        final Map<Integer, IntegrationObject> nodeMap = new HashMap<>();
        final IntegrationGraph integrationGraph = integrationGraphService.getIntegrationGraph();
        for (final NodesItem node : integrationGraph.getNodes()) {
            final IntegrationObject integrationObject = integrationObjectMapper.apply(node);
            nodeMap.put(node.getNodeId(), integrationObject);
        }

        for (final LinksItem links : integrationGraph.getLinks()) {
            final IntegrationObject source = nodeMap.get(links.getFrom());
            final IntegrationObject target = nodeMap.get(links.getTo());
            source.getOutputObjects().add(target);
            target.getInputObjects().add(source);
        }

        integrationObjectRepository.saveAll(nodeMap.values());
    }

}
