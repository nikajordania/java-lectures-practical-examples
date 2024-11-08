package practical_1.v2;

class Product {
    String productName;
    String category;
    double price;

    public Product(String productName, String category, double price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public void getProductInfo() {
        String message = """
                Product Name: %s
                Category: %s
                Price: %s₾
                
                """;
        System.out.printf(message, productName, category, price);
    }

    public void applyDiscount() {
        double discount;
        String categoryInLowerCase = category.toLowerCase();
        if (categoryInLowerCase.equals("electronics")) {
            discount = 0.10;
        } else if (categoryInLowerCase.equals("clothing")) {
            discount = 0.30;
        } else if (categoryInLowerCase.equals("furniture")) {
            discount = 0.50;
        } else {
            System.out.println("No discount available for category: " + category);
            return;
        }

        price -= price * discount;
        System.out.printf(("Price after %s %% discount: %s₾"), discount * 100, price);
    }


    public void adjustPriceForSeason(String season) {
        double adjustmentFactor;
        String slc = season.toLowerCase();
        String categoryLowerCase = category.toLowerCase();
        if (slc.equalsIgnoreCase("winter")) {
            if (categoryLowerCase.equals("heaters") || categoryLowerCase.equals("jackets")) {
                adjustmentFactor = 0.20;
                System.out.println("Increasing price for high-demand winter items.");
            } else {
                adjustmentFactor = -0.10;
                System.out.println("Applying winter clearance discount.");
            }
        } else if (slc.equalsIgnoreCase("summer")) {
            if (categoryLowerCase.equals("air conditioners") || categoryLowerCase.equals("swimwear")) {
                adjustmentFactor = 0.20;
                System.out.println("Increasing price for high-demand summer items.");
            } else {
                adjustmentFactor = -0.10;
                System.out.println("Applying summer clearance discount.");
            }
        } else {
            System.out.println("No seasonal adjustment applied for: " + season);
            return;
        }

        price += price * adjustmentFactor;
        System.out.printf("New price after seasonal adjustment: %s₾\n", price);
    }

}
