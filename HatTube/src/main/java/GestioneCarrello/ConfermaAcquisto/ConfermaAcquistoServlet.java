package GestioneCarrello.ConfermaAcquisto;

import LogicTier.GestioneCarrello.Carrello_Service;
import LogicTier.Oggetti.Acquisto;
import LogicTier.Oggetti.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/ConfermaAcquistoServlet")

public class ConfermaAcquistoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = "/Interface/CarrelloGUI/ConfermaAcquisto.jsp";

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        Carrello_Service carrello_service = new Carrello_Service();
        Acquisto acquisto = carrello_service.confermaAcquisto(cliente);

        if (acquisto != null) {
            request.setAttribute("aqcuisto", acquisto);
        }else {
            address = "/Interface/CarrelloGUI/PaginaCarrelloGUI/carrello.jsp";}

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

        }

    }


