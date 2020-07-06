package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import io.github.eaxdev.jsonsql4j.query.insert.InsertQuery;
import io.github.eaxdev.jsonsql4j.query.select.SelectQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertTest {

    @Test
    @DisplayName("Should get insert")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("insert/Insert.json");
        Query insertQuery = new InsertQuery(json);
        assertEquals("INSERT INTO security.audit (eventType, eventDate, userId) " +
                "VALUES ('MODIFY', '2020-01-01T23:28:56.782Z', 100);", insertQuery.getQuery());
    }

}
