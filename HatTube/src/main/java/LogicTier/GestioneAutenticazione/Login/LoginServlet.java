package LogicTier.GestioneAutenticazione.Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value ="/LoginServlet")
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address="/Interface/AutenticazioneGUI/paginaLogin.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

}
