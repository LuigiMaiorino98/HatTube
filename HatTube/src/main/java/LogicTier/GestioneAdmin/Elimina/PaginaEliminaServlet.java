package LogicTier.GestioneAdmin.Elimina;


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

@WebServlet(value="/PaginaEliminaServlet")
public class PaginaEliminaServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address="/Interface/AdminGUI/AdmEliminaGUI/AdmCatalogoElimina.jsp";
        Cappelli_Service cappelliService = new Cappelli_Service();
        ArrayList<Cappello> cappelli = cappelliService.recuperaTutti();
        request.setAttribute("cappelli",cappelli);

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }
}

