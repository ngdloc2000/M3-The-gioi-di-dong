package controller;

import config.SessionUtil;
import dao.cart.CartDAO;
import dao.cart.ICartDao;
import dao.cartDetail.CartDetailDAO;
import dao.cartDetail.ICartDetailDAO;
import dao.product.IProduct;
import dao.product.ProductDAO;
import dao.type.ITypeDAO;
import dao.type.TypeDAO;
import model.*;

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
    ITypeDAO typeDAO = new TypeDAO();
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
            case "pay":
                pay(request,response);
                break;
            case "filter":
                filterProduct(request,response);
                break;
            default:
                showHome(request,response);
                break;

        }

    }

    private void filterProduct(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");
        int idTypes = Integer.parseInt(request.getParameter("idTypes"));
        List<Product> list = productDAO.findByIdType(idTypes);
        List<Type> types = typeDAO.findAll();
        request.setAttribute("idUser",idUser);
        request.setAttribute("list",list);
        request.setAttribute("types",types);
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

    private void pay(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        Cart cart = cartDAO.findById(idCart);
        cart.setStatus(1);
        cartDAO.update(idCart,cart);
        try {
            response.sendRedirect("/guest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Product product = productDAO.findById(idProduct);
        request.setAttribute("product",product);
        request.setAttribute("idCart",idCart);
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
        List<ShowCart> list = cartDetailDAO.showCartByidCart(idCart);
        request.setAttribute("list",list);
        request.setAttribute("idCart",idCart);
        request.setAttribute("idUser",idUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/showCart.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");
        List<Product> list = productDAO.findAll();
        List<Type> types = typeDAO.findAll();
        request.setAttribute("idUser",idUser);
        request.setAttribute("list",list);
        request.setAttribute("types",types);
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
            case "details":
                addProductToCart(request,response);
                break;
    }
}

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        int number = Integer.parseInt(request.getParameter("number"));
        CartDetail cartDetail = cartDetailDAO.findCartDetailForIdProductAndIdCart(idCart,idProduct);
        if(cartDetail != null){
            int numberOld = cartDetail.getNumber();
            int numberNew = numberOld + number;
            cartDetailDAO.update(numberNew,cartDetail);
        }
        else {
            cartDetailDAO.add(new CartDetail(idCart,idProduct,number));
        }
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
