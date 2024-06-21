package de.rjst.springintegrationneo4jimporter.adapter;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IntegrationGraph{

	@JsonProperty("nodes")
	private List<NodesItem> nodes;

	@JsonProperty("links")
	private List<LinksItem> links;


}
