package io.github.eaxdev.jsonsql4j.query.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;
import io.github.eaxdev.jsonsql4j.model.Delete;
import io.github.eaxdev.jsonsql4j.query.ClauseBuilder;
import io.github.eaxdev.jsonsql4j.query.Query;
import io.github.eaxdev.jsonsql4j.query.WhereClauseBuilder;

/**
 * @author eaxdev
 */
public class DeleteQuery implements Query {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Delete delete;

    private final ClauseBuilder whereBuilder;

    public DeleteQuery(String jsonQuery) {
        //validate by schema
        try {
            this.delete = MAPPER.readValue(jsonQuery, Delete.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
        whereBuilder = new WhereClauseBuilder(delete.getCriteria());
    }

    @Override
    public String getQuery() {
        return "DELETE FROM " + delete.getFromView() + whereBuilder.build();
    }
}
