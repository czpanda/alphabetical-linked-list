import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList firstList;
    private LinkedList secondList;
    private LinkedList thirdList;

    @BeforeEach
    public void beforeEach() {
        firstList = new LinkedList()
                .add("Second item")
                .add("First item")
                .add("Third item")
                .add("Fourth item");

        secondList = new LinkedList()
                .add("ZZ item")
                .add("ZB item")
                .add("ZA item")
                .add("Q item")
                .add("A item")
                .add("PP item")
                .add("PA item")
                .add("Pa item");

        thirdList = new LinkedList();
    }

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

    @Test
    public void testRemove() {
        firstList.remove(0);

        assertTrue(firstList.getSize() == 3);
        assertFalse(firstList.contains("First item"));
        assertEquals("Fourth item -> Second item -> Third item", firstList.toString());

        secondList.remove(4);
        secondList.remove(5);

        assertTrue(secondList.getSize() == 6);
        assertFalse(secondList.contains("Q item"));
        assertFalse(secondList.contains("ZB item"));
        assertEquals("A item -> PA item -> PP item -> Pa item -> ZA item -> ZZ item", secondList.toString());

        assertThrows(IndexOutOfBoundsException.class, () -> secondList.remove(10), "Index has to be within list's size!\nPassed value: 10\nMax Value: 7");

    }

    @Test
    public void testGet() {
        assertEquals("First item", firstList.get(0));
        assertEquals("Fourth item", firstList.get(1));
        assertEquals("Second item", firstList.get(2));
        assertEquals("Third item", firstList.get(3));

        assertThrows(IndexOutOfBoundsException.class, () -> firstList.get(4), "Index has to be within list's size!\nPassed value: 4\nMax Value: 3");

        assertEquals("A item", secondList.get(0));
        assertEquals("PA item", secondList.get(1));
        assertEquals("PP item", secondList.get(2));
        assertEquals("Pa item", secondList.get(3));
        assertEquals("Q item", secondList.get(4));
        assertEquals("ZA item", secondList.get(5));
        assertEquals("ZB item", secondList.get(6));
        assertEquals("ZZ item", secondList.get(7));

        assertThrows(IndexOutOfBoundsException.class, () -> secondList.get(10), "Index has to be within list's size!\nPassed value: 10\nMax Value: 7");

    }
}
