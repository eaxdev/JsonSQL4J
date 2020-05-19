package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.List;

/**
 * @author eaxdev
 */
@Getter
@JsonTypeName("and")
public class And extends GroupCriteria {

    public And(List<Criteria> criteria) {
        super(criteria);
    }

    @Override
    @JsonIgnore
    public ConditionalOperator getConditionalOperator() {
        return ConditionalOperator.AND;
    }

}
