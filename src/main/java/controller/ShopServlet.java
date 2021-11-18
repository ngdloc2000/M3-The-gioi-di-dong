package controller;

import config.SessionUtil;
import dao.account.AccountDAO;
import dao.account.IAccount;
import dao.cartDetail.CartDetailDAO;
import dao.cartDetail.ICartDetailDAO;
import dao.product.IProduct;
import dao.product.ProductDAO;
import dao.shop.IShopDAO;
import dao.shop.ShopDAO;
import dao.type.ITypeDAO;
import dao.type.TypeDAO;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shops")
public class ShopServlet extends HttpServlet {
    IShopDAO shopDAO = new ShopDAO();
    IAccount accountDAO = new AccountDAO();
    ITypeDAO typeDAO = new TypeDAO();
    ICartDetailDAO cartDetailDAO = new CartDetailDAO();
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
            case "shopDetail":
                showShopDetailForm(request, response);
                break;
            case "createProductToShop":
                showCreateProductForm(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
            case "showAllCart":
                showAllCart(request, response);
                break;
            case "showCartDetail":
                showCartDetail(request, response);
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
                createShop(request, response);
                break;
            case "edit":
                break;
            case "createProductToShop":
                createProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void showAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        List<Cart> cartList = this.shopDAO.findAllCartsByIdShop(idShop);
        request.setAttribute("cartList", cartList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/listCart.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        int id = Integer.parseInt(request.getParameter("idProduct"));
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        shopDAO.removeProductOfShop(id);
        List<Product> productList = this.shopDAO.findAllProductsByShopAndUser(idUser, idShop);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shops?action=shopDetail&idShop=" + idShop);
        dispatcher.forward(request, response);
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        Shop shop = shopDAO.findById(idShop);
        List<Type> typeList = this.typeDAO.findAll();
        Account account = accountDAO.findById(idUser);
        request.setAttribute("shop", shop);
        request.setAttribute("typelist", typeList);
        request.setAttribute("account", account);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/createProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        int idType = Integer.parseInt(request.getParameter("idType"));
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        Type type = typeDAO.findById(idType);
        Shop shop = shopDAO.findById(idShop);
        Product product = new Product(name, price, quantity, image, type, shop);
        shopDAO.createProductToShop(product);
        request.setAttribute("shop", shop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/createProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showShopForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        List<Shop> shopList = shopDAO.findAllShopByIdUser(idUser);
        int total = shopDAO.totalShopByIdUser(idUser);
        Account account = accountDAO.findById(idUser);
        request.setAttribute("account", account);
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

    private void createShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        String name = request.getParameter("name");
        Account user = this.accountDAO.findById(idUser);
        Shop shop = new Shop(name, user);
        this.shopDAO.add(shop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showShopDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        List<Product> productList = this.shopDAO.findAllProductsByShopAndUser(idUser, idShop);
        Account account = this.accountDAO.findById(idUser);
        Shop shop = this.shopDAO.findById(idShop);
        request.setAttribute("shop", shop);
        request.setAttribute("account", account);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop/shopDetail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCartDetail(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        CartDetail cartDetail = cartDetailDAO.findById(idCart);
    }
}
