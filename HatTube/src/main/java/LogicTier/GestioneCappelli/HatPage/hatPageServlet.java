package LogicTier.GestioneCappelli.HatPage;

import LogicTier.GestioneCappelli.Cappelli_Service;
import LogicTier.Oggetti.Cappello;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value ="/hatPageServlet")
public class hatPageServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id= Integer.parseInt(request.getParameter("cappelloID"));
        Cappelli_Service cappelliService = new Cappelli_Service();
        Cappello cappello = cappelliService.recuperaCappello(id);
        String address="/Interface/CappelloGUI/HatPageGUI/hatPage.jsp";
        request.setAttribute("cappello",cappello);
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

}

