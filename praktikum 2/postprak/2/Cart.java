import java.util.ArrayList;

class Cart {
    private ArrayList<Product> products;
    private double totalPrice;

    Cart() {
        products = new ArrayList<Product>();
        totalPrice = 0.0;
    }
    
    public void addProduct(Product p) {
        if (p != null) {
            products.add(p);
            totalPrice += p.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void showCart() {
        System.out.println("Isi Keranjang:");
        if (products.isEmpty()) {
            System.out.println("(Kosong)");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i).toString());
            }
            System.out.println("Total harga: " + totalPrice);
        }
    }

    public void clearCart() {
        products.clear();
        totalPrice = 0.0;
    }
}
