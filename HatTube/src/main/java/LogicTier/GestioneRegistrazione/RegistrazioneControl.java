package LogicTier.GestioneRegistrazione;

import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value="/NuovoUtenteServlet")
public class RegistrazioneControl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address = "/Interface/RegistrazioneGUI/paginaRegistrazione.jsp";

        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        Registrazione_Service service= new Registrazione_Service();
        if(service.ValidaNome(request.getParameter("nome")) && service.ValidaCognome(request.getParameter("cognome")) && service.ValidaCitta(request.getParameter("citta")) && service.ValidaVia(request.getParameter("via") )&& service.ValidaCap((request.getParameter("cap"))) && service.ValidaNumCarta((request.getParameter("numcarta")))&& service.ValidaCVV(Integer.parseInt(request.getParameter("cvv"))) && service.ValidaNomeI(request.getParameter("nomei" ))&& service.ValidaData(request.getParameter("MeseS")+ "\\" +request.getParameter("AnnoS")) && service.ValidaEmail(request.getParameter("email")) && service.ValidaPassword(request.getParameter("password")) && service.ValidaUsername(request.getParameter("username"))) {
            cliente.setNome(request.getParameter("nome"));
            cliente.setCognome(request.getParameter("cognome"));
            cliente.setCitta(request.getParameter("citta"));
            cliente.setVia(request.getParameter("via"));
            cliente.setCAP(request.getParameter("cap"));
            cliente.setPassword(request.getParameter("password"));
            cliente.setUsername(request.getParameter("username"));
            cliente.setEmail(request.getParameter("email"));
            metodoPagamento.setCvv(Integer.parseInt(request.getParameter("cvv")));
            metodoPagamento.setIntestatario(request.getParameter("nomei"));
            metodoPagamento.setNumcarta(request.getParameter("numcarta"));
            metodoPagamento.setDataScadenza(request.getParameter("MeseS")+ "\\" +request.getParameter("AnnoS"));
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("cliente",service.SalvaCliente(metodoPagamento,cliente));
            address = "/Interface/AutenticazioneGUI/paginaLogin.jsp";
        }else {
            request.setAttribute("cliente" , cliente);
            request.setAttribute("metodopagamento", metodoPagamento);
        }
        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
