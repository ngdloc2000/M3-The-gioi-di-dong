package dao.account;

import dao.IDao;
import model.Account;

public interface IAccount extends IDao<Account> {
    public int validateUser(String email, String password);
    public Account findByEmail(String username);
}
