package practical_1.v2;

class ElectronicProduct extends Product {
    int stockCount;

    public ElectronicProduct(String productName, String category, double price, int stockCount) {
        super(productName, category, price);
        this.stockCount = stockCount;
    }

    @Override
    public void getProductInfo() {
        super.getProductInfo();
        System.out.println("Stock Count: " + stockCount);
        if (stockCount < 10) {
            System.out.println("Warning: Stock is low!");
        }
    }
}
