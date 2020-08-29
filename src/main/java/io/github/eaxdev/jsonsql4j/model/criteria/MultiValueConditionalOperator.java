package io.github.eaxdev.jsonsql4j.model.criteria;

import lombok.Getter;

/**
 * @author eaxdev
 */
@Getter
public enum MultiValueConditionalOperator {

    IN(" IN ");

    private final String queryView;

    MultiValueConditionalOperator(String queryView) {
        this.queryView = queryView;
    }

}
