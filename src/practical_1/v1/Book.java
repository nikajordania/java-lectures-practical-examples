package practical_1.v1;

class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void getBookInfo() {
        String message = """
                Title: %s
                Author: %s
                Price: %s₾
                
                """;
        System.out.printf(message, title, author, price);
    }

    public void applyDiscount(double discount) {
        if (discount > 50) {
            System.out.println("Discount cannot exceed 50%.");
        } else {
            price -= price * (discount / 100);
            System.out.println("Price after " + discount + "% discount: ₾" + price);
        }
    }

    public void increasePrice(double amount) {
        this.price += amount;
        System.out.println("Price after increase: ₾" + price);
    }
}
