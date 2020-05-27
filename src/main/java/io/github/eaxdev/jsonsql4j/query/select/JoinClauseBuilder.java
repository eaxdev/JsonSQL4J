package io.github.eaxdev.jsonsql4j.query.select;

import io.github.eaxdev.jsonsql4j.model.Join;
import io.github.eaxdev.jsonsql4j.model.criteria.GroupCriteria;
import io.github.eaxdev.jsonsql4j.model.criteria.SimpleCriteria;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @author eaxdev
 */
@RequiredArgsConstructor
public class JoinClauseBuilder {

    private final List<Join> joins;

    public String build() {
        if (Objects.isNull(joins) || joins.isEmpty()) {
            return "";
        }
        final StringBuilder result = new StringBuilder();

        for (Join join : joins) {
            result.append(join.getJoinType().getQueryView());

            if (Objects.isNull(join.getSchemaName()) || join.getSchemaName().isEmpty()) {
                result.append(join.getTable());
            } else {
                result.append(join.getSchemaName())
                        .append(".")
                        .append(join.getTable());
            }
            result.append(" ON ")
                    .append(join.getOn().getField())
                    .append(" = ")
                    .append(join.getOn().getValue());

        }
        return result.toString();
    }

}
