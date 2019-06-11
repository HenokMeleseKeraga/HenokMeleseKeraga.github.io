import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/support")
public class CsTechSupport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>cstech support</title></head><body>");
        out.print("<form method='post'>");
        out.print("<lable> Name <input type='text' name='name'/></lable></br>");
        out.print("<lable>Email<input type='email' name='email'/></lable></br>");
        out.print("<lable>Problem <input type='text'/></lable></br>");
        out.print("<lable>Problem description <textarea></textarea></label></br>");

        out.print("<input type='submit' value='SUBMIT'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String cemail=getServletContext().getInitParameter("CEmail");
       Long ticket= Math.round(Math.random() * ( 1000  ));
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Thank you! "+ name  +" us. We should receive reply from us with in 24 hrs in your email address " +
                email+"</p>");
        out.print("<p>Let us know in our support email  "+ cemail  +" if you don’t receive reply within 24 hrs. Please be sure to attach your reference " +
                ticket+" in your email </p>");
        out.print("</body></html>");
    }
}
