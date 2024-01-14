package LogicTier.GestioneAdmin.Aggiungi;


import LogicTier.GestioneAdmin.Admin_Service;
import LogicTier.Oggetti.Cappello;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*Prendiamo i valori del form all'interno della jsp di aggiunta, controllando prima che questi valori siano corretti*/
@WebServlet(value = "/AdmInserisciCappelloServlet")
public class AggiungiControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address="/Interface/AdminGUI/AdmAddGUI/AdmAdd.jsp";

        Cappello cappello=new Cappello();


        cappello.setDescrizione(request.getParameter("descrizione"));
        cappello.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
        cappello.setImmagine(request.getParameter("immagine"));
        cappello.setMarca(request.getParameter("marca"));
        cappello.setModello(request.getParameter("modello"));
        cappello.setQuantita(Integer.parseInt(request.getParameter("quantita")));
        cappello.setImmagine(request.getParameter("immagine"));
        cappello.setCategoria(request.getParameter("tipo"));

        Admin_Service admin_service=new Admin_Service();
        if(admin_service.addCappelloValidazione(cappello)){
            address="/Interface/AdminGUI/AdmHub.jsp";
        }
        else {
            request.setAttribute("cappello",cappello);
        }

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);


    }
}

