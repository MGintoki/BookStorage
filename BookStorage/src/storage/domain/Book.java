package storage.domain;


public class Book {
    private int bid;
    private int cid;
    private String name;
    private String author;
    private double price;
    private String img;
    private String description;


    public Book(){

    }
    public Book(int bid, int cid, String name, String author, double price, String img, String description) {
        this.bid = bid;
        this.cid = cid;
        this.name = name;
        this.author = author;
        this.price = price;
        this.img = img;
        this.description = description;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}