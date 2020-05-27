package io.github.eaxdev.jsonsql4j.model;

import lombok.Getter;

/**
 * @author eaxdev
 */
@Getter
public enum JoinType {

    INNER(" INNER JOIN "),

    RIGHT(" RIGHT JOIN "),

    LEFT(" LEFT JOIN ");

    private final String queryView;

    JoinType(String queryView) {
        this.queryView = queryView;
    }
}
