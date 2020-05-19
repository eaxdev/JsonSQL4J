package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("le")
@NoArgsConstructor
public class Le extends SimpleCriteria {

    public Le(String fieldName, String value) {
        super(fieldName, value);
    }

    @Override
    public ConditionalOperator getConditionalOperator() {
        return ConditionalOperator.LESS_THAN_EQUALS;
    }
}
