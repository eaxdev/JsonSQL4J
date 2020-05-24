package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("lt")
@NoArgsConstructor
public class Lt extends SimpleCriteria {

    public Lt(String fieldName, String value) {
        super(fieldName, value);
    }

    @Override
    public SimpleConditionalOperator getSimpleConditionalOperator() {
        return SimpleConditionalOperator.LESS_THAN;
    }
}
