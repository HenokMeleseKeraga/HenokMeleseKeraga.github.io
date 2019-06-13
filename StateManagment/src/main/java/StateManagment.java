import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/login"})
public class StateManagment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember =req.getParameter("remember");


        User user1=new User(username,password);
 //       if(Validate.userValidate(new db().getDb(),user1)){

        if (remember!= null){
            Cookie cUserName = new Cookie("cookuser", username);
            Cookie cRemember = new Cookie("cookrem", remember);
            cUserName.setMaxAge(60 * 60 * 24 * 30);//30 days
            cRemember.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cUserName);
            resp.addCookie(cRemember);

        }else{
            Cookie[] cookies=req.getCookies();
            if (cookies != null) {
                Cookie cUserName = new Cookie("cookuser", null);
                Cookie cRemember = new Cookie("cookrem", null);
                cUserName.setMaxAge(0);
                cRemember.setMaxAge(0);
                resp.addCookie(cUserName);
                resp.addCookie(cRemember);
            }
        }
        Cookie promo=new Cookie("value","$100");
        promo.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(promo);
        HttpSession session=req.getSession();
        session.setAttribute("username" ,username);
        RequestDispatcher dispatcher=req.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(req,resp);



//        }
//        else{
//            resp.sendRedirect("login.jsp");
//        }


    }
}
