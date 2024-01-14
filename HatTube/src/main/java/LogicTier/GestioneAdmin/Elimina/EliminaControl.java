package LogicTier.GestioneAdmin.Elimina;

import LogicTier.GestioneAdmin.Admin_Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/confermaEliminaServlet")

public class EliminaControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address="/Interface/AdminGUI/AdmHub.jsp";
        int codice= Integer.parseInt(request.getParameter("cappelloID"));

        if(codice>=0) {
            Admin_Service admin_service=new Admin_Service();
            admin_service.eliminaCappello(codice);
        }

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }
}
