package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JException;
import io.github.eaxdev.jsonsql4j.query.select.SelectQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author eaxdev
 */
class SelectTest {

    @Test
    @DisplayName("Should get select")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("select/Select.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1", selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get select with simple criteria")
    void shouldGetSelectWithSimpleCriteria() {
        String json = TestUtil.readFileByPath("select/SelectWithSimpleCriteria.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE field3 = 5",
                selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get select with [and] criteria")
    void shouldGetSelectWithAndCriteria() {
        String json = TestUtil.readFileByPath("select/SelectWithAndCriteria.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 AND field4 = 3)",
                selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get select with [or] criteria")
    void shouldGetSelectWithOrCriteria() {
        String json = TestUtil.readFileByPath("select/SelectWithOrCriteria.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 OR field4 = 3)",
                selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get select with join")
    void shouldGetSelectWithJoin() {
        String json = TestUtil.readFileByPath("select/SelectWithJoin.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 INNER JOIN schema2.table2 ON field2 = field3",
                selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get simple select with join")
    void shouldGetSelectWithExpression() {
        String json = TestUtil.readFileByPath("select/SelectWithExpression.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT count(*) FROM schema.table1", selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get simple select with in operator (strings) in criteria")
    void shouldGetSelectWithInOperatorStringsInCriteria() {
        String json = TestUtil.readFileByPath("select/SelectWithInOperatorStringsInCriteria.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 " +
                "WHERE (field3 IN ('US', 'UK', 'IN', 'NZ') OR field4 = 3)", selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get simple select with in operator (digits) in criteria")
    void shouldGetSelectWithInOperatorDigitsInCriteria() {
        String json = TestUtil.readFileByPath("select/SelectWithInOperatorDigitsInCriteria.json");
        Query selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 " +
                "WHERE (field3 IN (5, 6, 7) OR field4 = 3)", selectQuery.getQuery());
    }

    @Test
    @DisplayName("Should get error when values in IN operator is different types")
    void shouldGetErrorWhenValuesInINOperatorDifferentTypes() {
        String json = TestUtil.readFileByPath("select/SelectWithInOperatorMultiTypesInCriteria.json");
        Query selectQuery = new SelectQuery(json);
        JsonSQL4JException jsonSQL4JException = assertThrows(JsonSQL4JException.class, selectQuery::getQuery);
        assertEquals("Values in IN operator must be same type", jsonSQL4JException.getMessage());
    }

}
