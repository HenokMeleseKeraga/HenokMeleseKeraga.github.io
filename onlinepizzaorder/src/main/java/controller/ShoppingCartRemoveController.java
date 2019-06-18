package controller;


import com.google.gson.Gson;
import dao.ShoppingCartDao;
import model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/shopping-cart/remove")
public class ShoppingCartRemoveController extends HttpServlet {

    private ShoppingCartDao shoppingCartDao;
    Gson mapper = new Gson();

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
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Product pro = mapper.fromJson(req.getParameter("products"), Product.class);
        shoppingCartDao.removeProduct(pro.getId());
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(pro));
    }
}
