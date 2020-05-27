package io.github.eaxdev.jsonsql4j.query.select;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;
import io.github.eaxdev.jsonsql4j.model.Select;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author eaxdev
 */
public class SelectQuery {

    private final Select select;

    private final WhereClauseBuilder whereBuilder;

    private final JoinClauseBuilder joinBuilder;

    public SelectQuery(String jsonQuery) {
        //validate by schema
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.select = objectMapper.readValue(jsonQuery, Select.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
        whereBuilder = new WhereClauseBuilder(select.getCriteria());
        joinBuilder = new JoinClauseBuilder(select.getJoins());
    }

    public String getSelect() {
        return "SELECT " +
                select.getFields().stream()
                        .map(f -> Objects.isNull(f.getAlias()) ? f.getColumn() : f.getColumn() + " AS " + f.getAlias())
                        .collect(Collectors.joining(", ")) +
                " FROM " + select.getTables().get(0).getSchemaName() + "." + select.getTables().get(0).getTableName()
                + whereBuilder.build()
                + joinBuilder.build();
    }
}
