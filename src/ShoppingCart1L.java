
import components.map.Map;
import components.map.Map1L;

/**
 * Implementation of the ShoppingCart component using a Map.
 *
 * @convention Each item has a nonnegative price and a positive quantity. Each
 *             item name is unique within the Map.
 *
 * @correspondence Each entry in the Map represents an item in the shopping
 *                 cart. The key is the item's name, and the value stores its
 *                 price and quantity.
 *
 * @author Frank Antalocy
 */
public class ShoppingCart1L extends ShoppingCartSecondary {

    /**
     * Representation of this shopping cart.
     */
    private Map<String, Item> items;

    /**
     * Creates an empty shopping cart.
     */
    public ShoppingCart1L() {
        this.items = new Map1L<String, Item>();
    }

    /**
     * Adds one occurrence of an item to this shopping cart.
     *
     * @param item
     *            the name of the item
     * @param price
     *            the price of the item
     */
    @Override
    public void addItem(String item, double price) {
        if (this.items.hasKey(item)) {
            Item current = this.items.value(item);
            current.setQuantity(current.getQuantity() + 1);
        } else {
            this.items.add(item, new Item(price, 1));
        }
    }

    /**
     * Removes one occurrence of an item from this shopping cart.
     *
     * @param item
     *            the name of the item
     */
    @Override
    public void removeItem(String item) {
        Item current = this.items.value(item);

        if (current.getQuantity() > 1) {
            current.setQuantity(current.getQuantity() - 1);
        } else {
            this.items.remove(item);
        }
    }

    /**
     * Returns the total number of items in this shopping cart.
     *
     * @return the number of items
     */
    @Override
    public int size() {
        int count = 0;

        for (Map.Pair<String, Item> pair : this.items) {
            count += pair.value().getQuantity();
        }

        return count;
    }

    /**
     * Returns the price of an item.
     *
     * @param item
     *            the name of the item
     * @return the price of the item
     */
    @Override
    public double getPrice(String item) {
        return this.items.value(item).getPrice();
    }

    /**
     * Checks whether this shopping cart contains an item.
     *
     * @param item
     *            the name of the item
     * @return true if the item exists
     */
    @Override
    public boolean hasItem(String item) {
        return this.items.hasKey(item);
    }

    /**
     * Removes and returns an arbitrary item entry.
     *
     * @return the removed entry
     */
    @Override
    public Map.Pair<String, Item> removeAnyItem() {
        return this.items.removeAny();
    }

    /**
     * Creates a new shopping cart of the same type.
     *
     * @return a new empty shopping cart
     */
    @Override
    public ShoppingCart newInstance() {
        return new ShoppingCart1L();
    }

    /**
     * Transfers the contents of another shopping cart into this one.
     *
     * @param source
     *            the shopping cart to transfer from
     */
    @Override
    public void transferFrom(ShoppingCart source) {
        ShoppingCart1L localSource = (ShoppingCart1L) source;

        this.items = localSource.items;
        localSource.items = new Map1L<String, Item>();
    }
}
