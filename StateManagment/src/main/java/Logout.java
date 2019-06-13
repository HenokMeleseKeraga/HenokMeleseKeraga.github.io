import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value={"/logout"})
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        String u=(String) session.getAttribute("username");
      System.out.println("logout");
        session.removeAttribute("username");
        session.invalidate();
        req.setAttribute("msg", "You have successfully logged out.");
        resp.sendRedirect("login.jsp");


    }


}
