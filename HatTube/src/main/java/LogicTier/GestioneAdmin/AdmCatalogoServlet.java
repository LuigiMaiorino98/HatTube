package LogicTier.GestioneAdmin;


import LogicTier.GestioneCappelli.Cappelli_Service;
import LogicTier.Oggetti.Cappello;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value ="/AdmCatalogoServlet")
public class AdmCatalogoServlet extends HttpServlet {

    /*Indirizza alla pagina di modifica*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cappelli_Service cappelloFACADE = new Cappelli_Service();
        ArrayList<Cappello> cappelli = cappelloFACADE.recuperaTutti();
        request.setAttribute("cappelli",cappelli);
        String address="/Interface/AdminGUI/AdmCatalogo.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}

