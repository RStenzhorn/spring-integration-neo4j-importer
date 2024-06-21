package de.rjst.springintegrationneo4jimporter.database;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node("IntegrationObject")
public class IntegrationObject {

    @Id
    @GeneratedValue
    private String id;

    private String componentType;

    private String input;

    private String integrationPatternCategory;

    private String name;

    private String integrationPatternType;

    private Integer nodeId;

    private String output;

    @Relationship(type = "INPUT")
    private Set<IntegrationObject> inputObjects = new HashSet<>();

    @Relationship(type = "OUTPUT")
    private Set<IntegrationObject> outputObjects= new HashSet<>();

}
