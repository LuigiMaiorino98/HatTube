package GestioneCarrello.AggiungiAlCarrello;



import LogicTier.GestioneCappelli.Cappelli_Service;
import LogicTier.GestioneCarrello.Carrello_Service;
import LogicTier.Oggetti.Cappello;
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

@WebServlet(value = "/AggiungiCarrelloServlet")

public class AggiungiCarrelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address="index.jsp";
        int id= Integer.parseInt(request.getParameter("cappelloID"));
        Cappelli_Service cappelliService = new Cappelli_Service();
        Cappello cappello = cappelliService.recuperaCappello(id);


        //Creazione prodotto
        int quantita= Integer.parseInt(request.getParameter("quantita"));//quantità prodotto
        Cappello item=new Cappello();
        item.setMarca(cappello.getMarca());
        double prezzo=cappello.getPrezzo()*quantita;
        item.setPrezzo(prezzo);
        item.setQuantita(quantita);
        item.setModello(cappello.getModello());
        item.setTipo(cappello.getTipo());


        //aggiunta prodotto al carrello dell'utente registrato
        HttpSession session=request.getSession(true);
        Cliente cliente= (Cliente) session.getAttribute("cliente");
        if(cliente!=null) {     //se è diverso da null l'utente è registrato (presente della Session )
            Carrello_Service carrello_service = new Carrello_Service();
            carrello_service.aggiungiCarrello(cliente,cappello);
        }
        else {  //ospite
            Carrello carrello= (Carrello) session.getAttribute("carrello");
            if(carrello!=null){     //esiste un carrello
                carrello.aggiungiProdotto(item);
                session.setAttribute("carrello",carrello);
            }
            else {
                Carrello carrelloNuovo=new Carrello();
                carrelloNuovo.aggiungiProdotto(item);
                session.setAttribute("carrello",carrelloNuovo);

            }
        }

                RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}

