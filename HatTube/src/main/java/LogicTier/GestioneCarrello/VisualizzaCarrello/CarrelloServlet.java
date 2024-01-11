package LogicTier.GestioneCarrello.VisualizzaCarrello;

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


@WebServlet(value = "/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address ="/Interface/CarrelloGUI/PaginaCarrelloGUI/carrello.jsp";

        HttpSession session=request.getSession();
        Cliente cliente= (Cliente) session.getAttribute("cliente");

        if(cliente!=null){  // verifico che l'utente sia loggato
            int idCarrello=cliente.getCarrello().getCarrelloId();
            Carrello_Service carrello_service=new Carrello_Service();
            Carrello carrello=carrello_service.recuperaCarrello(idCarrello);

            request.setAttribute("prodotti",carrello.getProdotti());
            request.setAttribute("carrello",carrello);
        }
        else {
            Carrello carrelloNonUtente= (Carrello) session.getAttribute("carrello");
            if(carrelloNonUtente!=null){
                request.setAttribute("prodotti",carrelloNonUtente.getProdotti());
            }
            else {
                Carrello carrello=new Carrello();
                session.setAttribute("carrello",carrello);
                request.setAttribute("prodotti",carrello.getProdotti());
            }
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
