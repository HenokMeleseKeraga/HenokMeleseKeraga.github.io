import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = {"/", "/login"})
public class StateManagment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
        //System.out.print("get method ");
        //dispatcher.forward(req,resp);
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember =req.getParameter("remember");
        // servlet context
        String un=getServletContext().getInitParameter("uname");
        String pw=getServletContext().getInitParameter("pword");
        User sampleperson= new User(un,pw);
        db dbnew= new db();
        dbnew.add(sampleperson);
        // ************

        User user1=new User(username,password);
        if(Validate.userValidate(dbnew.getDb(),user1)){

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

        HttpSession session=req.getSession();// to tell the container  i want to create or use a session after this stm container take care of every thing
        session.setAttribute("username" ,username);
        req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }
       else{
             req.getSession().setAttribute("msg","Invalide username or password");
            resp.sendRedirect("login.jsp");
        }


    }
}
