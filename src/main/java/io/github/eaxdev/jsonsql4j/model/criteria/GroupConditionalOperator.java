package io.github.eaxdev.jsonsql4j.model.criteria;

import lombok.Getter;

/**
 * @author eaxdev
 */
@Getter
public enum GroupConditionalOperator {

    AND("and", " AND "),

    OR("or", " OR ");

    private final String jsonView;

    private final String queryView;

    GroupConditionalOperator(String jsonView, String queryView) {
        this.jsonView = jsonView;
        this.queryView = queryView;
    }
}
