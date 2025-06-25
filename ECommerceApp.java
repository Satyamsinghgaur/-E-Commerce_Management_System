import java.util.*;

public class ECommerceApp {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        User user = new User("Satyam");

        // Predefined products
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Smartphone", 22000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Smart Watch", 3500));
        products.add(new Product(5, "Bluetooth Speaker", 2500));

        while (true) {
            System.out.println("\n=== E-Commerce Store ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: viewProducts(); break;
                case 2: addToCart(user); break;
                case 3: user.viewCart(); break;
                case 4: user.checkout(); break;
                case 5:
                    System.out.println("Exiting app. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void addToCart(User user) {
        System.out.print("Enter Product ID to add: ");
        int id = sc.nextInt();
        Product selectedProduct = null;

        for (Product p : products) {
            if (p.getId() == id) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Invalid product ID.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("Quantity must be at least 1.");
            return;
        }

        user.addToCart(selectedProduct, qty);
    }
}
