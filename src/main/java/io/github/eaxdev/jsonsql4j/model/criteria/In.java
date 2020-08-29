package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("in")
@NoArgsConstructor
public class In extends MultiValueCriteria {

    public In(String fieldName, List<String> values) {
        super(fieldName, values);
    }

    @Override
    public CriteriaType getCriteriaType() {
        return CriteriaType.MULTI_VALUE;
    }

    @Override
    public MultiValueConditionalOperator getMultiValueConditionalOperator() {
        return MultiValueConditionalOperator.IN;
    }
}
