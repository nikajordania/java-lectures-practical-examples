package practical_1.v1;

class EBook extends Book {
    double fileSize;

    public EBook(String title, String author, double price, double fileSize) {
        super(title, author, price);
        this.fileSize = fileSize;
    }

    @Override
    public void getBookInfo() {
        super.getBookInfo();
        if (fileSize < 1024) {
            System.out.printf("File Size: %s KB\n", fileSize);
        } else {
            System.out.printf("File Size: %s MB\n", (fileSize / 1024));
        }
    }
}
