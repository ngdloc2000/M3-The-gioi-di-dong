package dao.cart;

import dao.IDao;
import model.Cart;

import java.util.List;

public interface ICartDao extends IDao<Cart> {
    public List<Cart> findAllCartByIdAccount(int idUser);
    public int findIdCartCartForIdAccount(List<Cart> list);
    public int addReturnIDCart(Cart cart);
}
