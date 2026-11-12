
/**
 * Interface for a shopping cart component that provides secondary methods
 * secondary methods for managing items and calculating price.
 *
 * @author Frank Antalocy
 */
public interface ShoppingCart extends ShoppingCartKernel {

    /**
     * Checks whether this shopping cart is empty.
     *
     * @return true if empty
     */
    boolean isEmpty();

    /**
     * Removes all items from this shopping cart.
     */
    @Override
    void clear();

    /**
     * Returns the quantity of an item of this.
     *
     * @param name
     *            the name of the item
     * @return the quantity of the item
     */
    int getQuantity(String name);

    /**
     * Returns the price of all items in this.
     *
     * @return the total price
     */
    double totalPrice();

    /**
     * Returns the price of the cheapest item of this.
     *
     * @return the price of the smallest item
     */
    double getSmallest();

    /**
     * Returns the price of the most expensive item of this.
     *
     * @return the price of the most expensive item
     */
    double getLargest();
}
