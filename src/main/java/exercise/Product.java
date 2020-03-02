package exercise;

enum Product {
    PRODUCT1("Product 1"), 
    PRODUCT2("Product 2"), 
    PRODUCT3("Product 3"), 
    PRODUCT4("Product 4");

    private String displayName;

    public String getDisplayName() {
        return this.displayName;
    }

    private Product(String name) {
        this.displayName = name;
    }
}