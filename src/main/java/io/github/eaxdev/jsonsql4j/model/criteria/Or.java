package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("or")
public class Or extends GroupCriteria {

    public Or(List<Criteria> criteria) {
        super(criteria);
    }

    @Override
    public ConditionalOperator getConditionalOperator() {
        return ConditionalOperator.OR;
    }

}
