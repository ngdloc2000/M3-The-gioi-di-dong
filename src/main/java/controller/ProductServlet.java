package controller;

import dao.product.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    public static final String SHOW_PRODUCT_JSP = "/showProduct.jsp";

    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                addProduct(request,response);
                break;
            case "find":
                findProductByID(request,response);
                break;
            case "update":
                updateProductById(request,response);
                break;
            case "remove":
                removeProductByID(request,response);
            default: showAllProduct(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
            case "find":
            case "update":
            case "remove":
            default:
        }
    }

    public void showAllProduct(HttpServletRequest request, HttpServletResponse response){
        List<Product> productList = productDAO.findAll();
        request.setAttribute("list",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SHOW_PRODUCT_JSP);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(HttpServletRequest request, HttpServletResponse response){
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int idType = Integer.parseInt(request.getParameter("idType"));
        Product product = new Product(nameProduct,price,quantity,description,idType);
        productDAO.add(product);
        showAllProduct(request, response);
    }
    public void findProductByID(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        Product product = productDAO.findById(idProduct);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("list",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(SHOW_PRODUCT_JSP);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void updateProductById(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int idType = Integer.parseInt(request.getParameter("idType"));
        Product product = new Product(nameProduct,price,quantity,description,idType);
        productDAO.update(idProduct,product);
        showAllProduct(request,response);
    }

    public void removeProductByID(HttpServletRequest request, HttpServletResponse response){
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        productDAO.remove(idProduct);
        showAllProduct(request,response);
    }
}
