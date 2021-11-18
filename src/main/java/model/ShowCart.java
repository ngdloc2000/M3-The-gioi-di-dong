package model;

public class ShowCart {
    String nameProduct;
    int number;
    float Price;
    float total;

    public ShowCart(String nameProduct, int number, float price) {
        this.nameProduct = nameProduct;
        this.number = number;
        Price = price;
        total = price * number;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
