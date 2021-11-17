package model;

public class Shop {
    int idShop;
    String nameShop;
    Account account;

    public Shop(int idShop, String nameShop, Account account) {
        this.idShop = idShop;
        this.nameShop = nameShop;
        this.account = account;
    }

    public Shop(String nameShop, Account account) {
        this.nameShop = nameShop;
        this.account = account;
    }

    public Shop(int idShop, String nameShop) {
        this.idShop = idShop;
        this.nameShop = nameShop;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "idShop=" + idShop +
                ", nameShop='" + nameShop + '\'' +
                ", account=" + account +
                '}';
    }
}
