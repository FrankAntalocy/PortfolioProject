
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit tests for the ShoppingCart1L component.
 */
public class ShoppingCart1LTest {

    /**
     * Tests a newly created shopping cart.
     */
    @Test
    public void testConstructor() {
        ShoppingCart cart = new ShoppingCart1L();

        assertEquals(0, cart.size());
        assertTrue(cart.isEmpty());
    }

    /**
     * Tests adding one item.
     */
    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);

        assertEquals(1, cart.size());
        assertTrue(cart.hasItem("apple"));
        assertEquals(1.50, cart.getPrice("apple"), 0.001);
    }

    /**
     * Tests adding duplicate items.
     */
    @Test
    public void testAddDuplicateItems() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);

        assertEquals(3, cart.size());
        assertEquals(3, cart.getQuantity("apple"));
    }

    /**
     * Tests removing one occurrence of an item.
     */
    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);

        cart.removeItem("apple");

        assertEquals(1, cart.size());
        assertEquals(1, cart.getQuantity("apple"));
    }

    /**
     * Tests removing the last occurrence of an item.
     */
    @Test
    public void testRemoveLastItem() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.removeItem("apple");

        assertEquals(0, cart.size());
        assertFalse(cart.hasItem("apple"));
    }

    /**
     * Tests size with different items and quantities.
     */
    @Test
    public void testSize() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("milk", 3.00);

        assertEquals(3, cart.size());
    }

    /**
     * Tests retrieving an item's price.
     */
    @Test
    public void testGetPrice() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("milk", 3.00);

        assertEquals(3.00, cart.getPrice("milk"), 0.001);
    }

    /**
     * Tests checking whether items exist.
     */
    @Test
    public void testHasItem() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);

        assertTrue(cart.hasItem("apple"));
        assertFalse(cart.hasItem("banana"));
    }

    /**
     * Tests removing an arbitrary item entry.
     */
    @Test
    public void testRemoveAnyItem() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);

        Map.Pair<String, Item> removed = cart.removeAnyItem();

        assertEquals("apple", removed.key());
        assertEquals(2, removed.value().getQuantity());
        assertEquals(0, cart.size());
    }

    /**
     * Tests checking whether the cart is empty.
     */
    @Test
    public void testIsEmpty() {
        ShoppingCart cart = new ShoppingCart1L();

        assertTrue(cart.isEmpty());

        cart.addItem("apple", 1.50);

        assertFalse(cart.isEmpty());
    }

    /**
     * Tests clearing the cart.
     */
    @Test
    public void testClear() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("milk", 3.00);

        cart.clear();

        assertEquals(0, cart.size());
        assertTrue(cart.isEmpty());
    }

    /**
     * Tests retrieving an item's quantity.
     */
    @Test
    public void testGetQuantity() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);

        assertEquals(3, cart.getQuantity("apple"));
        assertEquals(3, cart.size());
    }

    /**
     * Tests calculating the total price.
     */
    @Test
    public void testTotalPrice() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("milk", 3.00);

        assertEquals(6.00, cart.totalPrice(), 0.001);
        assertEquals(3, cart.size());
    }

    /**
     * Tests finding the smallest price.
     */
    @Test
    public void testGetSmallest() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("milk", 3.00);
        cart.addItem("banana", 0.75);

        assertEquals(0.75, cart.getSmallest(), 0.001);
        assertEquals(3, cart.size());
    }

    /**
     * Tests finding the largest price.
     */
    @Test
    public void testGetLargest() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);
        cart.addItem("milk", 3.00);
        cart.addItem("banana", 0.75);

        assertEquals(3.00, cart.getLargest(), 0.001);
        assertEquals(3, cart.size());
    }

    /**
     * Tests creating a new instance.
     */
    @Test
    public void testNewInstance() {
        ShoppingCart cart = new ShoppingCart1L();

        cart.addItem("apple", 1.50);

        ShoppingCart newCart = cart.newInstance();

        assertEquals(0, newCart.size());
        assertEquals(1, cart.size());
    }

    /**
     * Tests transferring items between shopping carts.
     */
    @Test
    public void testTransferFrom() {
        ShoppingCart source = new ShoppingCart1L();
        ShoppingCart destination = new ShoppingCart1L();

        source.addItem("apple", 1.50);
        source.addItem("apple", 1.50);
        source.addItem("milk", 3.00);

        destination.transferFrom(source);

        assertEquals(0, source.size());
        assertEquals(3, destination.size());
        assertEquals(2, destination.getQuantity("apple"));
        assertEquals(3.00, destination.getPrice("milk"), 0.001);
    }
}
