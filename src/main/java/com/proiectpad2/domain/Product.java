package com.proiectpad2.domain;

public class Product{
    // @Id
    private int pid;
    private String productName;
    private String price;
    private String ingredients;
    private String quantity;
    private String food;
    private String pic;

    public int getPid() {
        return pid;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFood() {
        return food;
    }

    public String getPic() {
        return pic;
    }
}