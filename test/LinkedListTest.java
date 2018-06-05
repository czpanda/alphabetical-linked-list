import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList firstList = new LinkedList()
        .addItem("Second item")
        .addItem("First item")
        .addItem("Third item")
        .addItem("Fourth item");

    private LinkedList secondList = new LinkedList()
        .addItem("ZZ item")
        .addItem("ZB item")
        .addItem("ZA item")
        .addItem("Q item")
        .addItem("A item")
        .addItem("PP item")
        .addItem("PA item")
        .addItem("Pa item");

    private LinkedList thirdList = new LinkedList();

    @Test
    public void testContains() {
        assertTrue(firstList.contains("Second item"));
        assertTrue(firstList.contains("First item"));
        assertTrue(firstList.contains("Third item"));
        assertTrue(firstList.contains("Fourth item"));
        assertFalse(firstList.contains("Some non existing item"));
        assertFalse(firstList.contains("Another non existing item"));

        assertTrue(secondList.contains("ZZ item"));
        assertTrue(secondList.contains("ZB item"));
        assertTrue(secondList.contains("ZA item"));
        assertTrue(secondList.contains("Q item"));
        assertTrue(secondList.contains("A item"));
        assertTrue(secondList.contains("PP item"));
        assertTrue(secondList.contains("PA item"));
        assertTrue(secondList.contains("Pa item"));
        assertFalse(secondList.contains("Non existing in the second list"));
    }

    @Test
    public void testSize() {
        assertTrue(firstList.getSize() == 4);
        assertTrue(secondList.getSize() == 8);
        assertTrue(thirdList.getSize() == 0);
    }

    @Test
    public void testToString() {
        assertEquals("First item -> Fourth item -> Second item -> Third item", firstList.toString());
        assertEquals("A item -> PA item -> PP item -> Pa item -> Q item -> ZA item -> ZB item -> ZZ item", secondList.toString(), "");
        assertEquals("Empty list!", thirdList.toString(), "");
    }
}
