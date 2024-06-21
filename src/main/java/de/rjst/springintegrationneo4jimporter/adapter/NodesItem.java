package de.rjst.springintegrationneo4jimporter.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NodesItem{

	@JsonProperty("componentType")
	private String componentType;

	@JsonProperty("input")
	private String input;

	@JsonProperty("integrationPatternCategory")
	private String integrationPatternCategory;

	@JsonProperty("name")
	private String name;

	@JsonProperty("integrationPatternType")
	private String integrationPatternType;

	@JsonProperty("nodeId")
	private int nodeId;

	@JsonProperty("observed")
	private boolean observed;

	@JsonProperty("output")
	private String output;

}
