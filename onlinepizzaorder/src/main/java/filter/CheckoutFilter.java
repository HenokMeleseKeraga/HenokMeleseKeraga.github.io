package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/checkout")
public class CheckoutFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {  }

  @Override
  public void destroy() {  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    HttpSession session = httpServletRequest.getSession();
    if (session != null && session.getAttribute("email") == null) {
      httpServletResponse.sendRedirect("login");
      return;
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
