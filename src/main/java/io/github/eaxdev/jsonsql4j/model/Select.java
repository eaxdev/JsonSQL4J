package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

/**
 * @author eaxdev
 */
@Value
public class Select {

    @JsonProperty(value = "fields", required = true)
    List<Field> fields;

    @JsonProperty(value = "from", required = true)
    List<Table> tables;

}

