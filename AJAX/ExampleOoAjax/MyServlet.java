import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userMessage = request.getParameter("message");
        request.setAttribute("message", userMessage);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
