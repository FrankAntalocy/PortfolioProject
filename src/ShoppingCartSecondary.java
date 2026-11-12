import components.map.Map;
import components.map.Map1L;

/**
 * Abstract class that implements the secondary methods of the ShoppingCart
 * component using its kernel methods.
 *
 * @author Frank Antalocy
 */
public abstract class ShoppingCartSecondary implements ShoppingCart {

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final void clear() {
        while (this.size() > 0) {
            this.removeAnyItem();
        }
    }

    @Override
    public final int getQuantity(String item) {
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

    @Override
    public final double totalPrice() {
        double total = 0.0;
        Map<String, Item> temp = new Map1L<String, Item>();

        while (this.size() > 0) {
            Map.Pair<String, Item> pair = this.removeAnyItem();
            total += pair.value().getPrice() * pair.value().getQuantity();
            temp.add(pair.key(), pair.value());
        }
        while (temp.size() > 0) {
            Map.Pair<String, Item> pair = temp.removeAny();
            for (int i = 0; i < pair.value().getQuantity(); i++) {
                this.addItem(pair.key(), pair.value().getQuantity());
            }
        }
        return total;
    }

    @Override
    public final double getSmallest() {
        double smallest = Double.MAX_VALUE;
        Map<String, Item> temp = new Map1L<String, Item>();
        while (this.size() > 0) {
            Map.Pair<String, Item> pair = this.removeAnyItem();
            if (pair.value().getPrice() < smallest) {
                smallest = pair.value().getPrice();
            }
            temp.add(pair.key(), pair.value());
        }
        while (temp.size() > 0) {
            Map.Pair<String, Item> pair = temp.removeAny();
            for (int i = 0; i < pair.value().getQuantity(); i++) {
                this.addItem(pair.key(), pair.value().getPrice());
            }
        }
        return smallest;
    }

    @Override
    public final double getLargest() {
        double largest = -Double.MAX_VALUE;
        Map<String, Item> temp = new Map1L<String, Item>();
        while (this.size() > 0) {
            Map.Pair<String, Item> pair = this.removeAnyItem();
            if (pair.value().getPrice() > largest) {
                largest = pair.value().getPrice();
            }
            temp.add(pair.key(), pair.value());
        }
        while (temp.size() > 0) {
            Map.Pair<String, Item> pair = temp.removeAny();
            for (int i = 0; i < pair.value().getQuantity(); i++) {
                this.addItem(pair.key(), pair.value().getPrice());
            }
        }
        return largest;
    }

}
