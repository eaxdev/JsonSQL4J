package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("eq")
@NoArgsConstructor
public class Eq extends SimpleCriteria {

    public Eq(String fieldName, String value) {
        super(fieldName, value);
    }

    @Override
    public ConditionalOperator getConditionalOperator() {
        return ConditionalOperator.EQUALS_TO;
    }
}
