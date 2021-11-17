package controller;

import config.SessionUtil;
import dao.account.AccountDAO;
import dao.account.IAccount;
import dao.product.IProduct;
import dao.product.ProductDAO;
import dao.shop.IShopDAO;
import dao.shop.ShopDAO;
import model.Account;
import model.Shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shops")
public class ShopServlet extends HttpServlet {
    IShopDAO shopDAO = new ShopDAO();
    IProduct productDAO = new ProductDAO();
    IAccount accountDAO = new AccountDAO();
    int idUser;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteShop(request, response);
                break;
            default:
                showShopForm(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            default:
                break;
        }
    }

    private void showShopForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        List<Shop> shopList = shopDAO.findAllShopByIdUser(idUser);
        int total = shopDAO.totalShopByIdUser(idUser);
        Account account = accountDAO.findById(idUser);
        request.setAttribute("account",account);
        request.setAttribute("shoplist", shopList);
        request.setAttribute("total", total);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("id"));
        Shop shop = shopDAO.findById(idShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/edit.jsp");
        request.setAttribute("shop", shop);
        dispatcher.forward(request, response);
    }

    private void deleteShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("id"));
        shopDAO.remove(idShop);
        List<Shop> shopList = shopDAO.findAll();
        request.setAttribute("shoplist", shopList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/list.jsp");
        dispatcher.forward(request, response);
    }
}
