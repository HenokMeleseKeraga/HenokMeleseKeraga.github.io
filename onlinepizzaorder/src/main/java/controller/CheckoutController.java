package controller;

import com.google.gson.Gson;
import dao.ShoppingCartDao;
import dao.UserDao;
import model.Order;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

  private ShoppingCartDao shoppingCartDao;

    Gson mapper = new Gson();
  private UserDao db;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(true);
    if (session != null && session.getAttribute("shoppingCartDao") != null) {
      shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
    } else {
      shoppingCartDao = new ShoppingCartDao();
      session.setAttribute("shoppingCartDao", shoppingCartDao);
    }

     db = (UserDao)getServletContext().getAttribute("db");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = db.getUser((String) req.getSession().getAttribute("email"));
    req.setAttribute("user", user);
    req.getRequestDispatcher("checkout.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse resp)
      throws ServletException, IOException {

      System.out.println("dopost ceackeot ");
      PrintWriter out = resp.getWriter();

    if (request.getParameter("order") != null) {

      Order order = mapper.fromJson(request.getParameter("order"), Order.class);
      HttpSession session = request.getSession();
      String email = (String)session.getAttribute("email");
      User user = db.getUserByEmail(email);
      System.out.println("order:"+order.getId());
      System.out.println("user :"+user.getEmail());
//      request.getSession().setAttribute("shoppingCartDao", null);
       out.print(mapper.toJson("success"));
    }
    else{
        out.print(mapper.toJson("failure"));
    }


  }
}
