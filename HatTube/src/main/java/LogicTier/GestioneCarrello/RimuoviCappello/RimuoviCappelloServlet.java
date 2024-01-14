package LogicTier.GestioneCarrello.RimuoviCappello;


import LogicTier.GestioneCarrello.Carrello_Service;
import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/RimuoviCappello")

public class RimuoviCappelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address ="/Interface/CarrelloGUI/PaginaCarrelloGUI/carrello.jsp";
        int id= Integer.parseInt(request.getParameter("id"));
        int idCappello = Integer.parseInt(request.getParameter("idCappello"));
        HttpSession session=request.getSession();
        Cliente cliente= (Cliente) session.getAttribute("cliente");

        if(cliente!=null){
            Carrello_Service carrello_service = new Carrello_Service();
            Carrello  carrello = carrello_service.rimuoviCappello(cliente,idCappello);
            request.setAttribute("prodotti",carrello.getProdotti());
            request.setAttribute("carrello",carrello);

        }
        else {
            Carrello carrello= (Carrello) session.getAttribute("carrello");
            if(carrello.getNumeroElementi()>=1){
                carrello.rimuoviCappelloUtente(id);
                request.setAttribute("prodotti", carrello.getProdotti());
                request.setAttribute("carrello", carrello);
            }
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}