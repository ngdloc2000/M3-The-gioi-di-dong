package controller;

import config.SessionUtil;
import dao.cart.CartDAO;
import dao.cart.ICartDao;
import dao.product.IProduct;
import dao.product.ProductDAO;
import model.Cart;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/carts")
public class CartServlet extends HttpServlet {

    public static final String SHOW_ALL_CART_JSP = "cart/ShowAllCart.jsp";
    public int idUser;
    IProduct productDAO = new ProductDAO();
    ICartDao cartDAO = new CartDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showFormAddCart(request,response);
                break;
            case "find":
                findCartById(request,response);
                break;
            case "update":
                updateCartById(request,response);
                break;
            case "remove":
                removeCartByID(request,response);
            default: showAllCart(request,response);
        }
    }

    private void showFormAddCart(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");
        List<Cart> list =cartDAO.findAllCartByIdAccount(idUser);
        if(list.size() == 0){
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            cartDAO.add(new Cart(idUser, date,0));
        }
        else {
            int idCart = cartDAO.findIdCartCartForIdAccount(list);
            if(idCart == -1){
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                cartDAO.add(new Cart(idUser, date,0));
            }
            else {
                Cart cart = cartDAO.findById(idCart);
                request.setAttribute("card",cart);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
                try {
                    requestDispatcher.forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addCart(request,response);
                break;
            case "find":
                findCartById(request,response);
                break;
            case "update":
                updateCartById(request,response);
                break;
            case "remove":
                removeCartByID(request,response);
            default: showAllCart(request,response);
        }
    }

    public void showAllCart(HttpServletRequest request, HttpServletResponse response){
        List<Cart> productList = cartDAO.findAll();
        request.setAttribute("list",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SHOW_ALL_CART_JSP);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addCart(HttpServletRequest request, HttpServletResponse response){
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int idType = Integer.parseInt(request.getParameter("idType"));
        Product product = new Product(nameProduct,price,quantity,description,idType);
        productDAO.add(product);
        showAllCart(request, response);
    }
    public void findCartById(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Product product = productDAO.findById(idProduct);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("list",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SHOW_ALL_CART_JSP);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void updateCartById(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int idType = Integer.parseInt(request.getParameter("idType"));
        Product product = new Product(nameProduct,price,quantity,description,idType);
        productDAO.update(idProduct,product);
        showAllCart(request,response);
    }

    public void removeCartByID(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        productDAO.remove(idProduct);
        showAllCart(request,response);
    }
}
