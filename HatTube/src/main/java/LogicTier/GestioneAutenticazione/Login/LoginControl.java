package LogicTier.GestioneAutenticazione.Login;

import LogicTier.GestioneAutenticazione.Login_Service;
import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet (value = "/ValidazioneLoginServlet")

public class LoginControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address ="/Interface/AutenticazioneGUI/paginaLogin.jsp";
        String email = request.getParameter("email");
        String password= request.getParameter("password");

        // verifichiamo se l'utente è presente nel DB se si ritorna un oggetto Cliente altrimenti null

        Login_Service login_service=new Login_Service();
        Cliente cliente=login_service.loginClienteFacade(email,password);
        if(cliente!=null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("cliente", cliente);
            address = "index.jsp";
        }
        else {
            Admin admin = login_service.loginAdminFacade(email,password);
            if (admin!=null) {

                HttpSession session = request.getSession(true);
                session.setAttribute("admin", admin);
                address = "/Interface/AdminGUI/AdmHub.jsp";
            }
        }

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}