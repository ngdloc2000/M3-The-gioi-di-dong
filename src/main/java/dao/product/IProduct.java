package dao.product;

import dao.IDao;
import model.Product;

import java.util.List;

public interface IProduct extends IDao<Product> {
    public List<Product> findByIdType(int idType);
}
