package de.rjst.springintegrationneo4jimporter.database;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IntegrationObjectRepository extends Neo4jRepository<IntegrationObject, String> {
}
