package dao.cartDetail;

import dao.IDao;
import model.Cart;
import model.CartDetail;
import model.ShowCart;

import java.util.List;

public interface ICartDetailDAO extends IDao<CartDetail> {
    public List<CartDetail> findAllCartDetailByIdCart(int idCart);
    public CartDetail findCartDetailForIdProductAndIdCart(int idProduct, int idCart);
    public List<ShowCart> showCartByidCart(int idCart);
}
