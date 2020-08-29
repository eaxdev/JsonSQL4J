package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author eaxdev
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleCriteria.class),
        @JsonSubTypes.Type(value = GroupCriteria.class),
        @JsonSubTypes.Type(value = MultiValueCriteria.class)
})
public interface Criteria {

    CriteriaType getCriteriaType();

}
