package dao.shop;

import dao.IDao;
import model.Cart;
import model.Product;
import model.Shop;

import java.util.List;

public interface IShopDAO extends IDao<Shop> {
    List<Shop> findAllShopByIdUser(int idUser);

    int totalShopByIdUser(int idUser);

    List<Product> findAllProductsByShopAndUser(int idUser, int idShop);

    void createProductToShop(Product product);

    void updateProductOfShop(int idProduct, int idUser);

    void removeProductOfShop(int idProduct);

    List<Cart> findAllCartsByIdShop(int idShop);
}
