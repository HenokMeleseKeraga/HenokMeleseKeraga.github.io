import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyservletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc=sce.getServletContext();
        String username=sc.getInitParameter("uname");
        String password=sc.getInitParameter("pword");
        sc.setAttribute("uname",username);
        sc.setAttribute("pword",password);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
