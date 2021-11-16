package controller;


import dao.IDao;
import dao.role.IRole;
import dao.role.RoleDAO;
import model.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    IRole iRole =  new RoleDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "show":
                    break;
                default:
                    listRole(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void listRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> roleList = iRole.findAll();
        request.setAttribute("list", roleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/test.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/register.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("tét");
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("acount/login.jsp");
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
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                showLoginForm(request,response);
        }
    }

}
