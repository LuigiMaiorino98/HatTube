package LogicTier.GestioneAdmin.Modifica;


import LogicTier.GestioneAdmin.Admin_Service;
import LogicTier.GestioneCappelli.Cappelli_Service;
import LogicTier.Oggetti.Cappello;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/AdmEffettuaModificheServlet")
public class ModificaControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address="/Interface/AdminGUI/AdmModGUI/AdmMod.jsp";
        int id = Integer.parseInt(request.getParameter("codice"));


        Cappelli_Service cappelliService=new Cappelli_Service();
        Cappello cappello = cappelliService.recuperaCappello(id);

        cappello.setDescrizione(request.getParameter("descrizione"));
        cappello.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
        cappello.setMarca(request.getParameter("marca"));
        cappello.setModello(request.getParameter("modello"));
        cappello.setQuantita(Integer.parseInt(request.getParameter("quantita")));
        cappello.setCategoria(request.getParameter("tipo"));


        Admin_Service admin_service=new Admin_Service();
        if(admin_service.modificaCappelloValidazione(cappello)) {
            admin_service.modificaCappello(cappello);
            address = "/Interface/AdminGUI/AdmHub.jsp";
        }
        else {
            request.setAttribute("cappello",cappello);
        }


        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);


    }
}

