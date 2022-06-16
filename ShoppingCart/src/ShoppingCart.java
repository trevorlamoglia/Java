import java.util.ArrayList;
import java.util.ListIterator;

class ShoppingCart {
    public static void main(String[] args) {
        Item i1 = new Item("Protein powder", 1, 29.99);
        Item i2 = new Item("Eggs", 60, 7.27);
        Item i3 = new Item("Bread", 2, 1.99);

        ShoppingCart cart = new ShoppingCart();

        //  add the item to the cart
        cart.addToCart(i1);
        cart.addToCart(i2);
        cart.addToCart(i3);

        /* Expected console output:
         * Protein powder: 1
         * Eggs: 60
         * Bread: 2
         */
        cart.showCart();
    }


    ArrayList<Item> item;
    ShoppingCart() {
        this.item = new ArrayList<Item>();
    }
    public void addToCart(Item item) {
        this.item.add(item);
    } 
    public void showCart() {
        ListIterator<Item> iterator = item.listIterator();
        while(iterator.hasNext()) {
            Item item1 = iterator.next();
            System.out.println(item1);
        }
    }
}
