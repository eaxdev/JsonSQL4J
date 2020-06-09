package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eaxdev.jsonsql4j.model.criteria.Criteria;
import lombok.Value;

import java.util.Objects;

/**
 * @author eaxdev
 */
@Value
public class Delete {

    @JsonProperty(value = "schema")
    String schema;

    @JsonProperty(value = "table", required = true)
    String table;

    @JsonProperty("where")
    Criteria criteria;

    public String getFromView() {
        return Objects.isNull(schema) || schema.isEmpty() ? table : schema + "." + table;
    }

}
