package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author eaxdev
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = And.class),
        @JsonSubTypes.Type(value = Or.class)})
@Getter
@AllArgsConstructor
@JsonDeserialize(using = GroupCriteriaDeserializer.class)
public abstract class GroupCriteria extends Criteria {

    protected final List<Criteria> criteria;
}
