package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;
import io.github.eaxdev.jsonsql4j.query.delete.DeleteQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author eaxdev
 */
public class DeleteTest {

    @Test
    @DisplayName("Should get delete")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("delete/Delete.json");
        Query deleteQuery = new DeleteQuery(json);
        assertEquals("DELETE FROM test", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get delete with schema")
    void shouldGetSelectWithSchema() {
        String json = TestUtil.readFileByPath("delete/DeleteWithSchema.json");
        Query deleteQuery = new DeleteQuery(json);
        assertEquals("DELETE FROM schema.test", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get delete with criteria")
    void shouldGetSelectWithCriteria() {
        String json = TestUtil.readFileByPath("delete/DeleteWithCriteria.json");
        Query deleteQuery = new DeleteQuery(json);
        assertEquals("DELETE FROM schema.test WHERE (field3 = 5 AND field4 = 3)", deleteQuery.getQuery());
    }

    @Test
    @DisplayName("Should get error when json is invalid")
    void shouldGetErrorWhenJsonIsInvalid() {
        JsonSQL4JParseException jsonSQL4JParseException = assertThrows(JsonSQL4JParseException.class,
                () -> new DeleteQuery("{\"invalid:\" \"json\"}"));
        assertEquals("Can not parse json query: [{\"invalid:\" \"json\"}]",
                jsonSQL4JParseException.getMessage());
    }
}
