import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList list = new LinkedList()
            .addItem("First item")
            .addItem("Second item")
            .addItem("Third item")
            .addItem("Fourth item");

    @Test
    public void testContains() {
        assertTrue(list.contains("Second item"));
        assertTrue(list.contains("First item"));
        assertTrue(list.contains("Fourth item"));
        assertTrue(list.contains("Third item"));
        assertFalse(list.contains("Some non existing item"));
        assertFalse(list.contains("Another non existing item"));
    }

    @Test
    public void testSize() {
        assertTrue(list.getSize() == 4);
    }

    @Test
    public void testToString() {
        assertEquals(list.toString(), "First item -> Second item -> Third item -> Fourth item");
    }
}
