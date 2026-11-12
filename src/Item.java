
/**
 * Represents an item in a shopping cart with a price and quantity.
 */
public class Item {

    /**
     * The price of the item.
     */
    private double price;

    /**
     * The quantity of the item.
     */
    private int quantity;

    /**
     * Creates an item with a price and quantity.
     *
     * @param price
     *            the price of the item
     * @param quantity
     *            the quantity of the item
     */
    public Item(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Updates the quantity of this item.
     *
     * @param quantity
     *            the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
