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
        return " WHERE " + (criteria.isGroup()
                ? constructGroupCriteria((GroupCriteria) criteria)
                : constructExpression((SimpleCriteria) criteria));
    }

    private String constructExpression(SimpleCriteria criteria) {
        switch (criteria.getSimpleConditionalOperator()) {
            case EQUALS_TO:
                return criteria.getFieldName() + SimpleConditionalOperator.EQUALS_TO.getView() + criteria.getValue();
            case NOT_EQUALS_TO:
                return criteria.getFieldName() + SimpleConditionalOperator.NOT_EQUALS_TO.getView() + criteria.getValue();
            case GREATER_THAN:
                return criteria.getFieldName() + SimpleConditionalOperator.GREATER_THAN.getView() + criteria.getValue();
            case GREATER_THAN_EQUALS:
                return criteria.getFieldName() + SimpleConditionalOperator.GREATER_THAN_EQUALS.getView() + criteria.getValue();
            case LESS_THAN:
                return criteria.getFieldName() + SimpleConditionalOperator.LESS_THAN.getView() + criteria.getValue();
            case LESS_THAN_EQUALS:
                return criteria.getFieldName() + SimpleConditionalOperator.LESS_THAN_EQUALS.getView() + criteria.getValue();
            case CONTAINS:
                return criteria.getFieldName() + SimpleConditionalOperator.CONTAINS.getView() + criteria.getValue();
            case NOT_CONTAINS:
                return criteria.getFieldName() + SimpleConditionalOperator.NOT_CONTAINS.getView() + criteria.getValue();
            default:
                throw new JsonSQL4JException("Conditional operator [" + criteria.getSimpleConditionalOperator() + "] is unexpected");
        }
    }

    private String constructGroupCriteria(GroupCriteria criteria) {
        if (criteria.getGroupConditionalOperator() == GroupConditionalOperator.AND) {
            String leftExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(0));
            String rightExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(1));
            return "(" + leftExpression + GroupConditionalOperator.AND.getQueryView() + rightExpression + ")";
        } else {
            String leftExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(0));
            String rightExpression = constructExpression((SimpleCriteria) criteria.getCriteria().get(1));
            return "(" + leftExpression + GroupConditionalOperator.OR.getQueryView() + rightExpression + ")";
        }
    }

}
