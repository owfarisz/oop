class User {
    private String name;
    private double balance;
    private Cart cart;

    private static int totalUserTransactions = 0;

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Product p) {
        cart.addProduct(p);
    }

    public void checkout() {
        double total = cart.getTotalPrice();
        if (balance >= total) {
            balance -= total;
            cart.clearCart();
            totalUserTransactions = totalUserTransactions + 1;
            // intentionally no output on success
        } else {
            System.out.println("Saldo tidak cukup");
        }
    }

    public void showProfile() {
        System.out.println("User: " + name + ", Saldo: " + balance);
        cart.showCart();
    }

    public static int getTotalUserTransactions() {
        return totalUserTransactions;
    }
}
