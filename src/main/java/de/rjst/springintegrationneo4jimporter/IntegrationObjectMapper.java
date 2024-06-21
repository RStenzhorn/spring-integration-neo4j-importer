package de.rjst.springintegrationneo4jimporter;

import de.rjst.springintegrationneo4jimporter.adapter.NodesItem;
import de.rjst.springintegrationneo4jimporter.database.IntegrationObject;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IntegrationObjectMapper implements Function<NodesItem, IntegrationObject> {

    @Override
    public IntegrationObject apply(final NodesItem nodesItem) {
        final IntegrationObject result = new IntegrationObject();
        result.setInput(nodesItem.getInput());
        result.setOutput(nodesItem.getOutput());
        result.setName(nodesItem.getName());
        result.setComponentType(nodesItem.getComponentType());
        result.setIntegrationPatternCategory(nodesItem.getIntegrationPatternCategory());
        result.setIntegrationPatternType(nodesItem.getIntegrationPatternType());
        result.setNodeId(nodesItem.getNodeId());
        return result;
    }
}
