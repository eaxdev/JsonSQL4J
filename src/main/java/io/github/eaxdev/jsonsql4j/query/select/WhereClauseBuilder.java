package io.github.eaxdev.jsonsql4j.query.select;

import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JException;
import io.github.eaxdev.jsonsql4j.model.criteria.*;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @author eaxdev
 */
@RequiredArgsConstructor
public class WhereClauseBuilder {

    private final Criteria criteria;

    public String build() {
        if (Objects.isNull(criteria)) {
            return "";
        }
        return " WHERE " + constructWhereClause();
    }

    private String constructWhereClause() {
        if (criteria.isGroup()) {
            return constructGroupCriteria((GroupCriteria) criteria);
        }
        return constructExpression((SimpleCriteria) criteria);

    }

    private String constructExpression(SimpleCriteria criteria) {
        switch (criteria.getSimpleConditionalOperator()) {
            case EQUALS_TO:
                return criteria.getFieldName() + SimpleConditionalOperator.EQUALS_TO.getView() + criteria.getValue();
            default:
                throw new JsonSQL4JException("Conditional operator [" + criteria.getSimpleConditionalOperator() + "] is unexpected");
        }
    }

    private String constructGroupCriteria(GroupCriteria criteria) {
        if (criteria.getGroupConditionalOperator() == GroupConditionalOperator.AND) {
            String leftExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(0));
            String rightExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(1));
            return "(" + leftExpression + GroupConditionalOperator.AND.getQueryView() + rightExpression + ")";
        }
        return "";
    }

}
