package io.github.eaxdev.jsonsql4j.query.select;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;
import io.github.eaxdev.jsonsql4j.model.Select;
import io.github.eaxdev.jsonsql4j.model.target.TargetClause;
import io.github.eaxdev.jsonsql4j.model.target.TargetClauseDeserializer;
import io.github.eaxdev.jsonsql4j.query.ClauseBuilder;
import io.github.eaxdev.jsonsql4j.query.Query;
import io.github.eaxdev.jsonsql4j.query.WhereClauseBuilder;

/**
 * @author eaxdev
 */
public class SelectQuery implements Query {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(TargetClause.class, new TargetClauseDeserializer(TargetClause.class));
        MAPPER.registerModule(module);
    }

    private final Select select;

    private final ClauseBuilder whereBuilder;

    private final ClauseBuilder joinBuilder;

    private final ClauseBuilder targetBuilder;

    public SelectQuery(String jsonQuery) {
        //validate by schema
        try {
            this.select = MAPPER.readValue(jsonQuery, Select.class);
        } catch (JsonProcessingException e) {
            throw new JsonSQL4JParseException("Can not parse json query: [" + jsonQuery + "]", e);
        }
        whereBuilder = new WhereClauseBuilder(select.getCriteria());
        joinBuilder = new JoinClauseBuilder(select.getJoins());
        targetBuilder = new TargetClauseBuilder(select.getFields());
    }

    @Override
    public String getQuery() {
        return "SELECT " +
                targetBuilder.build() +
                " FROM " + select.getTables().get(0).getSchemaName() + "." + select.getTables().get(0).getTableName()
                + whereBuilder.build()
                + joinBuilder.build();
    }
}
