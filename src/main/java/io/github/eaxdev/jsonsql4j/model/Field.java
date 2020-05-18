package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class Field {

    @JsonProperty(value = "column", required = true)
    String column;

    @JsonProperty(value = "alias")
    String alias;

}
