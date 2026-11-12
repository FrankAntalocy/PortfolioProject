import components.map.Map;
import components.standard.Standard;

/**
 * Kernal interface for a shopping cart component that stores items and
 * calculates the total price.
 */
public interface ShoppingCartKernel extends Standard<ShoppingCart> {

    /**
     * Adds an item to this shopping cart.
     *
     * @param item
     *            the name of the item
     * @param price
     *            the price of the item
     */
    void addItem(String item, double price);

    /**
     * Removes an item from this shopping cart.
     *
     * @param item
     *            the name of an item.
     */
    void removeItem(String item);

    /**
     * Returns the size of this shopping cart.
     *
     * @return the size of the shopping cart
     */
    int size();

    /**
     * Returns the price of this shopping cart item.
     *
     * @param item
     *            the name of the item
     * @return the price of item
     */
    double getPrice(String item);

    /**
     * Returns whether this shopping cart has item.
     *
     * @param item
     *            the name of the item
     * @return true if this shopping cart has item
     */
    boolean hasItem(String item);

    /**
     * Removes and returns any item from this shopping cart.
     *
     * @return any item from this
     */
    Map.Pair<String, Item> removeAnyItem();

}
