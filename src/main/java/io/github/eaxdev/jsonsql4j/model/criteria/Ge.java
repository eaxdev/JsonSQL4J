package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("ge")
@NoArgsConstructor
public class Ge extends SimpleCriteria {

    public Ge(String fieldName, String value) {
        super(fieldName, value);
    }

    @Override
    public ConditionalOperator getConditionalOperator() {
        return ConditionalOperator.GREATER_THAN_EQUALS;
    }
}
