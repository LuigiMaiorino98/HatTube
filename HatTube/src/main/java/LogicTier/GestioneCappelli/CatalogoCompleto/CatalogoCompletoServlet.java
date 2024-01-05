package LogicTier.GestioneCappelli.CatalogoCompleto;
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


@WebServlet(value = "/CatalogoCompletoServlet")
public class CatalogoCompletoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cappelli_Service cappelliService = new Cappelli_Service();
        ArrayList<Cappello> cappelli = cappelliService.recuperaTutti();
        request.setAttribute("cappelli",cappelli);
        String address= "/Interface/CappelloGUI/CatalogoDinamicoGUI/VisualizzazioneCatalogo.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }

    public void destroy(){

    }

}

