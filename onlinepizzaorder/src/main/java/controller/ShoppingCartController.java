package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShoppingCartDao;
import model.CartProduct;


@WebServlet("/shopping-cart")
public class ShoppingCartController extends HttpServlet {
    private ShoppingCartDao shoppingCartDao;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);// to create session if not have  if there is return a session

//  session !=null and session.getAttribute(sc)==null -> addis ligeza

        if (session != null && session.getAttribute("shoppingCartDao") != null) {
            shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
        } else {
            shoppingCartDao = new ShoppingCartDao();// session null  no login or regisration
            session.setAttribute("shoppingCartDao", shoppingCartDao);
        }
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        shoppingCartDao.addProduct(Integer.parseInt(req.getParameter("productId")));
        resp.setContentType("text/plain");
        // to take the array from shoppingCartDao and sum the quauntity
        List<CartProduct> totalCartList=shoppingCartDao.getMyCart();
        int quantity=0;
        for(CartProduct cp:totalCartList){
            quantity+=cp.getQty();
        }
        resp.getWriter().write(Integer.toString(quantity));

//        resp.getWriter().write(Integer.toString(shoppingCartDao.getMyCart().size()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("myCart", shoppingCartDao.getMyCart());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("shopping-cart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
