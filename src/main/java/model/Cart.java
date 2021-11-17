package model;

import dao.product.IProduct;
import dao.product.ProductDAO;

import java.util.Date;
import java.util.List;

public class Cart {
    private int idCart ;
    private int idAccount;
    private Date createDate;
    private int status;
    private List<Product> productList;

    public Cart(int idCart, int idAccount, Date createDate, int status) {
        this.idCart = idCart;
        this.idAccount = idAccount;
        this.createDate = createDate;
        this.status = status;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<Product> getProductList() {
        IProduct product = new ProductDAO();
        ICartDetailDAO cartDetail = new CartDetailDAO();
        CartDetail cartDetail = cartDetail.findById(idCart);
        List<Product> productList = product.findById();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
