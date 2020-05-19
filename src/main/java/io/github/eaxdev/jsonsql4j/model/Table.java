package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class Table {

    @JsonProperty(value = "table", required = true)
    String tableName;

    @JsonProperty(value = "schema")
    String schemaName;

}
