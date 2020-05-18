package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eaxdev
 */
public class SelectTest {

    @Test
    void simpleSelect() {
        String json = TestUtil.readFileByPath("SimpleSelect.json");
        SelectQuery selectQuery = new SelectQuery(json);
        assertEquals("SELECT field1, field2 AS test FROM", selectQuery.getSelect());
    }
}
