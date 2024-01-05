package LogicTier.GestioneCappelli.CatalogoPesca;

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

@WebServlet(value ="/CatalogoPescaServlet")
public class CatalogoPescaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cappelli_Service cappelliService = new Cappelli_Service();
        ArrayList<Cappello> cappelli = cappelliService.recuperaCategoria("pesca");
        request.setAttribute("cappelli",cappelli);
        String address="/Interface/CappelloGUI/CatalogoDinamicoGUI/VisualizzazioneCatalogo.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}