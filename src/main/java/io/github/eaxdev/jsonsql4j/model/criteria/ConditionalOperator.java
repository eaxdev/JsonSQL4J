package io.github.eaxdev.jsonsql4j.model.criteria;

import lombok.Getter;

/**
 * @author eaxdev
 */
@Getter
public enum ConditionalOperator {

    EQUALS_TO("eq"),

    NOT_EQUALS_TO("ne"),

    GREATER_THAN("gt"),

    GREATER_THAN_EQUALS("ge"),

    LESS_THAN("lt"),

    LESS_THAN_EQUALS("le"),

    CONTAINS("contains"),

    AND("and"),

    OR("or");

    private final String type;

    ConditionalOperator(String type) {
        this.type = type;
    }

}
