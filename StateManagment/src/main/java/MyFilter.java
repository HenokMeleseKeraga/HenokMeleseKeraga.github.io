import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       String uname=servletRequest.getParameter("username");
       String pword=servletRequest.getParameter("password");

       User user=new User(uname,pword);
       if(Validate.userValidate(new db().getDb(),user)) {
           System.out.println(" filter if");
           filterChain.doFilter(servletRequest,servletResponse);
       }else{
           System.out.println(" filter else");
           RequestDispatcher dispatcher=servletRequest.getRequestDispatcher("login.jsp");
           dispatcher.forward(servletRequest,servletResponse);

       }


    }

    @Override
    public void destroy() {

    }
}
