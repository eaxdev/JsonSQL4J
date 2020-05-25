package io.github.eaxdev.jsonsql4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class On {

    @JsonProperty("field")
    String field;

    @JsonProperty("value")
    String value;

}
