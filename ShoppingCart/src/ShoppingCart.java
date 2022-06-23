import java.util.ArrayList;
import java.util.ListIterator;

class ShoppingCart {
    public static void main(String[] args) {
        Item i1 = new Item("Protein powder", 1, 29.99);
        Item i2 = new Item("Eggs", 60, 7.27);
        Item i3 = new Item("Bread", 2, 1.99);
        Item i4 = new Item("Cheese Slices", 2, 2.99);
        Item i5 = new Item("Milk", 1, 3.49);

        ShoppingCart cart = new ShoppingCart();

        //  add the item to the cart
        cart.addToCart(i1);
        cart.addToCart(i2);
        cart.addToCart(i3);
        cart.addToCart(i4);
        cart.addToCart(i5);

        /* Expected console output:
         * Protein powder: 1
         * Eggs: 60
         * Bread: 2
         * Cheese Slices: 2
         * Milk: 1
         */
        cart.showCart();

        /* remove the item sent as argument from the cart */
        cart.removeFromCart(i3); 
        
         /*
        * shows the list of items in the cart with quantity
        * Expected Output to the console:
        * Protein powder: 1
        * Eggs: 60
        * Cheese Slices: 2
        * Milk: 1
        */
        cart.showCart();

        /*
        * gets the total amount for the items in the cart
        * Expected Output:
        * 476.66
        */
        double totalAmount = cart.getTotalAmount();
        System.out.println(totalAmount);

        /*
        * Protein powder  1       29.99    29.99
        * Eggs            60       7.27   436.2
        * Cheese Slices   2        2.99     5.98
        * Milk            1        3.49     3.49
                            Total:        475.66
         */
        cart.printInvoice();
    }



    ArrayList<Item> item;
    double totalAmount;
    ShoppingCart() {
        this.item = new ArrayList<Item>();
        this.totalAmount = 0;
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
    public void removeFromCart(Item i) {
        ListIterator<Item> iterator1 = item.listIterator();
        while(iterator1.hasNext()) {
			Item item2 = iterator1.next();
			if (item2.getProductName().equals(i.getProductName())) {
				this.item.remove(i);
				break;
			}
		}
    }
    public double getTotalAmount() {
		ListIterator<Item> iterator2 = item.listIterator();
		this.totalAmount = 0;
		while(iterator2.hasNext()) {
			Item item3 = iterator2.next();
			this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
		}
		return this.totalAmount;
	}
    public void printInvoice() {
		ListIterator<Item> iterator3 = item.listIterator();
		while(iterator3.hasNext()) {
			Item item4 = iterator3.next();
			System.out.print(item4.getProductName() + "\t");
			System.out.print(item4.getQuantity() + "\t");
			System.out.print(item4.getUnitPrice() + "\t");
			System.out.println(item4.getUnitPrice() * item4.getQuantity());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
	}
    
}
