package io.github.eaxdev.jsonsql4j.model.join;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class Join {

    @JsonProperty(value = "type", required = true)
    JoinType joinType;

    @JsonProperty(value = "schema")
    String schemaName;

    @JsonProperty("table")
    String table;

    @JsonProperty("on")
    On on;
}
