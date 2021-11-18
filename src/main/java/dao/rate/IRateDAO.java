package dao.rate;

import dao.IDao;
import model.Rate;

import java.util.List;

public interface IRateDAO extends IDao<Rate> {
    List<Rate> findAllRateByIdProduct(int idProduct);
    List<Rate> findAllRateByIdAccount(int idAccount);
}
