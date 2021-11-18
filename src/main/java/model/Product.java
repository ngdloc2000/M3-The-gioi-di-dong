package model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private int price;
    private int quantity;
    private String image;
    private int idType;
    private Type type;
    private int idShop;
    private Shop shop;
    public Product(){}

    public int getIdProduct() {
        return idProduct;
    }

    public Product(String nameProduct, int price, int quantity, String image, Type type, Shop shop) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
        this.shop = shop;
    }

    public Product(int idProduct, String nameProduct, int price, int quantity, String image, Type type, int idShop) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
        this.idShop = idShop;

    }

    public Product(int idProduct, String nameProduct, int price, int quantity, String image, Type type, Shop shop) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.type = type;
        this.shop = shop;
    }

    public Product(int idProduct, String nameProduct, int price, int quantity, String image, int idType, Type type, int idShop, Shop shop) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.idType = idType;
        this.type = type;
        this.idShop = idShop;
        this.shop = shop;
    }

    public Product(String nameProduct, int price, int quantity, String image, int idType) {

        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.idType = idType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
