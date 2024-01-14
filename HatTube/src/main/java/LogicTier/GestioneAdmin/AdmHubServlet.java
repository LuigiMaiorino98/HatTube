package LogicTier.GestioneAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value ="/AdmHubServlet")
public class AdmHubServlet extends HttpServlet {

    /*Reindirizza all' AdmHub*/

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address="/Interface/AdminGUI/AdmHub.jsp";

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}

