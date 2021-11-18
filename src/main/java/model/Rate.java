package model;

import dao.account.AccountDAO;
import dao.account.IAccount;
import dao.product.IProduct;
import dao.product.ProductDAO;

public class Rate {
    private int idRate;
    private String comment;
    private int rate;
    private Account account;
    private Product product;

    public Rate(int idRate, int idAccount, int idProduct, String comment, int rate) {
        IAccount account1 = new AccountDAO();
        IProduct product1 = new ProductDAO();
        this.idRate = idRate;
        this.comment = comment;
        this.rate = rate;
        this.account = account1.findById(idAccount);
        this.product = product1.findById(idProduct);
    }
    public Rate( int idAccount, int idProduct, String comment, int rate) {
        IAccount account1 = new AccountDAO();
        IProduct product1 = new ProductDAO();
        this.comment = comment;
        this.rate = rate;
        this.account = account1.findById(idAccount);
        this.product = product1.findById(idProduct);
    }

    public Rate(int idRate, String comment, int rate, Account account, Product product) {
        this.idRate = idRate;
        this.comment = comment;
        this.rate = rate;
        this.account = account;
        this.product = product;
    }


    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
