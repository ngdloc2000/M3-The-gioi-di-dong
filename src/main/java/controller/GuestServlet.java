package controller;

import config.SessionUtil;
import dao.cart.CartDAO;
import dao.cart.ICartDao;
import dao.cartDetail.CartDetailDAO;
import dao.cartDetail.ICartDetailDAO;
import dao.product.IProduct;
import dao.product.ProductDAO;
import dao.rate.IRateDAO;
import dao.rate.RateDAO;
import model.Cart;
import model.CartDetail;
import model.Product;
import model.Rate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GuestServlet", value = "/guest")
public class GuestServlet extends HttpServlet {
    IProduct productDAO = new ProductDAO();
    ICartDao cartDAO = new CartDAO();
    ICartDetailDAO cartDetailDAO = new CartDetailDAO();
    IRateDAO rateDAO = new RateDAO();
    int idUser;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showcart":
                showCart(request,response);
                break;
            case "details":
                showDetailProduct(request,response);
                break;
            case "addComment":
                addComment(request,response);
                break;
            default:
                showHome(request,response);
                break;

        }

    }

    private void addComment(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        String comment = request.getParameter("comment");
        int rate = Integer.parseInt(request.getParameter("rate"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        request.setAttribute("idCart",idCart);
        Product product = productDAO.findById(idProduct);
        request.setAttribute("product",product);
        rateDAO.add(new Rate(idUser,idProduct,comment,rate));
        List<Rate> rateList = rateDAO.findAllRateByIdProduct(idProduct);
        request.setAttribute("rateList",rateList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/detailProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        request.setAttribute("idCart",idCart);
        Product product = productDAO.findById(idProduct);
        request.setAttribute("product",product);
        List<Rate> rateList = rateDAO.findAllRateByIdProduct(idProduct);
        request.setAttribute("rateList",rateList);
        int avgRate = rateDAO.findAVGRateByIdProduct(idProduct);
        request.setAttribute("avgRate", avgRate);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/detailProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");



    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");
        List<Product> list = productDAO.findAll();
        request.setAttribute("idUser",idUser);
        request.setAttribute("list",list);
        AddCart(request,response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void AddCart(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request, "idUser");
        List<Cart> list = cartDAO.findAllCartByIdAccount(idUser);
        if (list.size() == 0) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            int idCart = cartDAO.addReturnIDCart(new Cart(idUser, date, 0));
            Cart cart = cartDAO.findById(idCart);
            request.setAttribute("cart", cart);
        } else {
            int idCart = cartDAO.findIdCartCartForIdAccount(list);
            if (idCart == -1) {
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                int idCart2 = cartDAO.addReturnIDCart(new Cart(idUser, date, 0));
                Cart cart = cartDAO.findById(idCart2);
                request.setAttribute("cart", cart);
            } else {
                Cart cart = cartDAO.findById(idCart);
                request.setAttribute("cart", cart);
            }
        }
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/home.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addComment":
                addComment(request,response);
                break;
            case "details":
                addProductToCart(request,response);
                break;
    }
}

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        int number = Integer.parseInt(request.getParameter("number"));
        cartDetailDAO.add(new CartDetail(idCart,idProduct,number));
        Product product =  productDAO.findById(idProduct);
        request.setAttribute("idCart",idCart);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/detailProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
