package dao.shop;

import dao.IDao;
import model.Shop;

import java.util.List;

public interface IShopDAO extends IDao<Shop> {
    List<Shop> findAllShopByIdUser(int idUser);
}
