package io.github.eaxdev.jsonsql4j.model.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @author eaxdev
 */
@Value
public class Expression implements TargetClause {

    @JsonProperty("expression")
    String expression;

    @Override
    public String getQueryView() {
        return expression;
    }
}
