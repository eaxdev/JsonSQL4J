package io.github.eaxdev.jsonsql4j.query;

import io.github.eaxdev.jsonsql4j.TestUtil;
import io.github.eaxdev.jsonsql4j.exception.JsonSQL4JParseException;
import io.github.eaxdev.jsonsql4j.query.delete.DeleteQuery;
import io.github.eaxdev.jsonsql4j.query.update.UpdateQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author eaxdev
 */
class UpdateTest {

    @Test
    @DisplayName("Should get update")
    void shouldGetSelect() {
        String json = TestUtil.readFileByPath("update/Update.json");
        Query updateQuery = new UpdateQuery(json);
        assertEquals("UPDATE security.audit " +
                "SET eventType = 'MODIFY', eventDate = '2020-01-01T23:28:56.782Z', userId = 100 " +
                "WHERE id = 5;", updateQuery.getQuery());
    }

}
