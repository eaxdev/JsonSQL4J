package io.github.eaxdev.jsonsql4j.model.target;

import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * @author eaxdev
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = Expression.class, name = "expression"),
        @JsonSubTypes.Type(value = Field.class, name = "column")})
public interface TargetClause {

    String getQueryView();

}
