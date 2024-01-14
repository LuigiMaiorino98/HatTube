package LogicTier.GestioneAdmin.StoricoOrdini;

import LogicTier.GestioneAdmin.Admin_Service;
import LogicTier.Oggetti.Acquisto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/StoricoOrdiniServlet")
public class StoricoOrdiniServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Admin_Service admin_service=new Admin_Service();
        ArrayList<Acquisto> acquisti = admin_service.recuperaAcquisti();
        if(acquisti.size()>=1){
            request.setAttribute("acquisti",acquisti);
        }

        String address = "/Interface/AdminGUI/StoricoOrdiniGUI/StoricoOrdini.jsp";
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
