package LogicTier.GestioneAdmin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/PaginaAdminServlet")

public class PaginaAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address="/Interface/AdminGUI/PaginaAdmin.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

}
