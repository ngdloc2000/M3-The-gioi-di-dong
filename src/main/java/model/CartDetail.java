package model;

public class CartDetail {
    private int IdCart;
    private int IdProduct;
    private int number;

    public CartDetail(int idCart, int idProduct, int number) {
        IdCart = idCart;
        IdProduct = idProduct;
        this.number = number;
    }

    public CartDetail() {
    }

    public int getIdCart() {
        return IdCart;
    }

    public void setIdCart(int idCart) {
        IdCart = idCart;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
