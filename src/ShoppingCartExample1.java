/**
 * Example of usefulness number 1.
 *
 * @author Frank Antalocy
 */
public final class ShoppingCartExample1 {

    /**
     * Private constructor.
     */
    private ShoppingCartExample1() {
    }

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart1L();

        //Add a few items
        cart.addItem("apple", 1.50);
        cart.addItem("apple", 1.50);
        cart.addItem("watermelon", 3.25);
        cart.addItem("grape", 0.5);

        //Output the largest, smallest, and total prices
        System.out.println("Number of Items: " + cart.size());
        System.out.println("Most expensive Item: " + cart.getLargest());
        System.out.println("Cheapest Item: " + cart.getSmallest());

        //Remove one item
        cart.removeItem("grape");

        //Check new cheapest and total price
        System.out.println("New cheapest: " + cart.getSmallest());
        System.out.println("Total price: " + cart.totalPrice());

        //Clear the cart and show that it has been cleared
        cart.clear();
        System.out.println("Empty: " + cart.isEmpty());
    }

}
