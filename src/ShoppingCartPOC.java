import components.map.Map;
import components.map.Map1L;

public class ShoppingCartPOC {

    private static class Item {
        double price;
        int quantity;

        Item(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    private Map<String, Item> items;

    public ShoppingCartPOC() {
        this.items = new Map1L<String, Item>();
    }

    public void addItem(String item, double price) {
        if (this.items.hasKey(item)) {
            Item currentCount = this.items.value(item);
            currentCount.quantity++;
        } else {
            this.items.add(item, new Item(price, 1));
        }
    }

    public void removeItem(String item) {
        Item currentCount = this.items.value(item);
        if (currentCount.quantity > 1) {
            currentCount.quantity--;
        } else {
            this.items.remove(item);
        }
    }

    public int size() {
        int count = 0;
        for (Map.Pair<String, Item> pair : this.items) {
            count += pair.value().quantity;
        }
        return count;
    }

    public Map.Pair<String, Item> removeAnyItem() {
        return this.items.removeAny();
    }

    public boolean hasItem(String item) {
        return this.items.hasKey(item);
    }

    public double getPrice(String item) {
        return this.items.value(item).price;
    }

    /**
     * Secondarys.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        while (this.size() > 0) {
            this.removeAnyItem();
        }
    }

    public int getQuantity(String item) {
        int count = 0;
        if (this.hasItem(item)) {
            double price = this.getPrice(item);

            while (this.hasItem(item)) {
                this.removeItem(item);
                count++;
            }
            for (int i = 0; i < count; i++) {
                this.addItem(item, price);
            }
        }
        return count;
    }

}
