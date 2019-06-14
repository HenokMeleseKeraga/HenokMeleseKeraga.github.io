import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/welcome.jsp")
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session=((HttpServletRequest)servletRequest).getSession(false);

        if(session!=null && session.getAttribute("username")!=null ){

            System.out.println(" filter if");
            filterChain.doFilter(servletRequest,servletResponse);


        }else{
            System.out.println(" filter else");
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }


    }

    @Override
    public void destroy() {

    }
}
