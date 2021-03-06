package io.github.eaxdev.jsonsql4j.query.select;

import io.github.eaxdev.jsonsql4j.model.target.TargetClause;
import io.github.eaxdev.jsonsql4j.query.ClauseBuilder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eaxdev
 */
@RequiredArgsConstructor
public class TargetClauseBuilder implements ClauseBuilder {

    private final List<TargetClause> targetClauses;

    @Override
    public String build() {
        return targetClauses.stream()
                .map(TargetClause::getQueryView)
                .collect(Collectors.joining(", "));
    }
}
