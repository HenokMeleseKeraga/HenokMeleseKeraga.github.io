package controller;

import dao.UserDao;
import model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = (String)request.getSession().getAttribute("email");

        UserDao db = (UserDao)getServletContext().getAttribute("db");
        User user = db.getUser(email);

        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
     //      request.setAttribute("error_login", "Incorrect email");
      //     request.getRequestDispatcher("profile.jsp").forward(request,response);
        }

    }
}
