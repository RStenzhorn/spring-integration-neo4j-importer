package de.rjst.springintegrationneo4jimporter.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LinksItem{

	@JsonProperty("from")
	private int from;

	@JsonProperty("to")
	private int to;

	@JsonProperty("type")
	private String type;

}
