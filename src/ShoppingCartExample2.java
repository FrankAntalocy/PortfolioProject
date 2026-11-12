
import components.map.Map;

/**
 * Demonstrates checking items and managing quantities in the ShoppingCart
 * component.
 */
public final class ShoppingCartExample2 {

    /**
     * Private constructor.
     */
    private ShoppingCartExample2() {
    }

    /**
     * Main method demonstrating the shopping cart.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart1L();

        // Add several items, including duplicates
        cart.addItem("banana", 0.75);
        cart.addItem("banana", 0.75);
        cart.addItem("banana", 0.75);
        cart.addItem("orange", 1.25);
        cart.addItem("milk", 3.50);

        // Check if certain items are in the cart
        System.out.println("Contains banana: " + cart.hasItem("banana"));
        System.out.println("Contains bread: " + cart.hasItem("bread"));

        // Check quantities of individual items
        System.out.println("Banana quantity: " + cart.getQuantity("banana"));
        System.out.println("Milk quantity: " + cart.getQuantity("milk"));

        // Check the price of an individual item
        System.out.println("Banana price: " + cart.getPrice("banana"));

        // Remove one banana
        cart.removeItem("banana");

        // Verify that only one occurrence was removed
        System.out.println(
                "Banana quantity after removal: " + cart.getQuantity("banana"));

        // Remove an arbitrary item entry
        Map.Pair<String, Item> removed = cart.removeAnyItem();

        System.out.println("Removed item: " + removed.key());
        System.out
                .println("Removed quantity: " + removed.value().getQuantity());

        // Check how many items remain
        System.out.println("Remaining items: " + cart.size());
    }
}
