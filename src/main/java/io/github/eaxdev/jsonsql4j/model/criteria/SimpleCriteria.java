package io.github.eaxdev.jsonsql4j.model.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eaxdev
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Eq.class),
        @JsonSubTypes.Type(value = Ge.class),
        @JsonSubTypes.Type(value = Gt.class),
        @JsonSubTypes.Type(value = Le.class),
        @JsonSubTypes.Type(value = Lt.class),
        @JsonSubTypes.Type(value = Ne.class),
        @JsonSubTypes.Type(value = Or.class),})
public abstract class SimpleCriteria extends Criteria {

    @JsonProperty(value = "fieldName", required = true)
    private String fieldName;

    @JsonProperty(value = "value", required = true)
    private String value;

    public abstract SimpleConditionalOperator getSimpleConditionalOperator();

    @Override
    public boolean isGroup() {
        return false;
    }
}
