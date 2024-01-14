
package LogicTier.GestioneAdmin.Aggiungi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*collega il button nell'hubAmd alla pagina di aggiunta*/
@WebServlet(value ="/AdmAddServlet")
public class AdmAddServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address="/Interface/AdminGUI/AdmAddGUI/AdmAdd.jsp";
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}

