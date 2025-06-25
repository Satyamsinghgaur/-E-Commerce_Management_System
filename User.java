import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<CartItem> cart;

    public User(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addToCart(Product product, int quantity) {
        cart.add(new CartItem(product, quantity));
        System.out.println(quantity + " x " + product.getName() + " added to cart.");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("\nYour Cart:");
        for (CartItem item : cart) {
            System.out.println(item);
            total += item.getTotalPrice();
        }
        System.out.println("Total: ₹" + total);
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
            return;
        }
        viewCart();
        System.out.println("Checkout complete. Thank you for shopping, " + name + "!");
        cart.clear();
    }
}
