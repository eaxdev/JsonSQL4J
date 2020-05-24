package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import io.github.eaxdev.jsonsql4j.query.select.SelectQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eaxdev
 */
public class SelectTest {

    @Test
    @DisplayName("Should get simple select")
    void simpleSelect() {
        String json = TestUtil.readFileByPath("SimpleSelect.json");
        SelectQuery selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1", selectQuery.getSelect());
    }

    @Test
    @DisplayName("Should get simple select with simple criteria")
    void simpleSelectWithSimpleCriteria() {
        String json = TestUtil.readFileByPath("SimpleSelectWithSimpleCriteria.json");
        SelectQuery selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE field3 = 5",
                selectQuery.getSelect());
    }

    @Test
    @DisplayName("Should get simple select with [and] criteria")
    void simpleSelectWithAndCriteria() {
        String json = TestUtil.readFileByPath("SimpleSelectWithAndCriteria.json");
        SelectQuery selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 AND field4 = 3)",
                selectQuery.getSelect());
    }

    @Test
    @DisplayName("Should get simple select with [or] criteria")
    void simpleSelectWithOrCriteria() {
        String json = TestUtil.readFileByPath("SimpleSelectWithOrCriteria.json");
        SelectQuery selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 OR field4 = 3)",
                selectQuery.getSelect());
    }
}
