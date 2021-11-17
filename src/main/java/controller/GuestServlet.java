package controller;

import config.SessionUtil;
import dao.product.IProduct;
import dao.product.ProductDAO;
import model.Product;

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
    int idUser;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showHome(request,response);
                break;
        }

    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        idUser = (int) SessionUtil.getInstance().getValue(request,"idUser");
        List<Product> list = productDAO.findAll();
        request.setAttribute("idUser",idUser);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("guest/home.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
