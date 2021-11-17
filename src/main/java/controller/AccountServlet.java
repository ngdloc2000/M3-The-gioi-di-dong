package controller;


import config.SessionUtil;
import dao.IDao;
import dao.account.AccountDAO;
import dao.account.IAccount;
import dao.role.IRole;
import dao.role.RoleDAO;
import model.Account;
import model.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    IRole iRole =  new RoleDAO();
    IAccount accountDAO = new AccountDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
<<<<<<< HEAD
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
=======
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "logout":
                logout(request,response);
                break;
            default:
                showLoginForm(request,response);
                break;
>>>>>>> khanh
        }

    }

    private void listRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> roleList = iRole.findAll();
        request.setAttribute("list", roleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/test.jsp");
        dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        SessionUtil.getInstance().removeValue(request,"idUser");
        try {
            response.sendRedirect("/accounts");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Role> list = iRole.findAll();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("acount/register.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            case "create":
                createAcount(request,response);
                break;
            default:
                login(request,response);
                break;
        }
    }

<<<<<<< HEAD
=======
    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int check = accountDAO.validateUser(username,password);
        if(check == -1){
            try {
                SessionUtil.getInstance().removeValue(request,"idUser");
                response.sendRedirect("/accounts");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if(check == 1){
                Account account = accountDAO.findByEmail(username);
                request.setAttribute("idUser",account.getIdUser());
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("##");
//                try {
//                    requestDispatcher.forward(request,response);
//                } catch (ServletException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                SessionUtil.getInstance().putValue(request,"idUser",account.getIdUser());
                try {
                    response.sendRedirect("/products");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(check == 2){

            }
            else if(check == 3){

            }
        }
    }

    private void createAcount(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int idRole = Integer.parseInt(request.getParameter("role"));
        Role role = iRole.findById(idRole);
        Account account = new Account(username,password,name,role);
        accountDAO.add(account);
        try {
            response.sendRedirect("/accounts");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
>>>>>>> khanh
}
