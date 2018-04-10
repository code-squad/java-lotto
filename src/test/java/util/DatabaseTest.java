package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {
    @Test
    public void connection() throws Exception {
        assertNotNull(Database.getConnection());
    }
}
