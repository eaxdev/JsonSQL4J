package io.github.eaxdev.jsonsql4j.model.criteria;

import lombok.Getter;

/**
 * @author eaxdev
 */
@Getter
public enum SimpleConditionalOperator {

    EQUALS_TO(" = "),

    NOT_EQUALS_TO(" != "),

    GREATER_THAN(" > "),

    GREATER_THAN_EQUALS(" >= "),

    LESS_THAN(" < "),

    LESS_THAN_EQUALS(" <= "),

    CONTAINS(" LIKE "),

    NOT_CONTAINS(" NOT LIKE ");

    private final String queryView;

    SimpleConditionalOperator(String queryView) {
        this.queryView = queryView;
    }

}
