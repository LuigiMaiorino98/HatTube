package LogicTier.GestioneRegistrazione;
import LogicTier.GestioneAutenticazione.Login_Service;
import LogicTier.Oggetti.Cliente;
import Storage.DAO.Utente.ClienteDAO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TestLogin {


    @Test
    public void TestEmailLogin(){
        Cliente cliente = new Cliente();
        cliente.setEmail("ciao123@gmail.com");
        cliente.setPassword("Ciao1234567");
        Login_Service login_service = new Login_Service();

        Assert.assertNull(login_service.loginCliente(cliente.getEmail(),cliente.getPassword()));
    }

    @Test
    public  void TestPasswordLogin(){
        Cliente cliente = new Cliente();
        cliente.setEmail("ciao123@gmail.com");
        cliente.setPassword("Ciao1234567");
        Login_Service login_service = new Login_Service();
        ClienteDAO clienteDaomok = Mockito.mock(ClienteDAO.class);
        login_service.setClienteDao(clienteDaomok);
        when(clienteDaomok.controlloEmail(cliente.getEmail())).thenReturn(true);
        Assert.assertNull(login_service.loginCliente(cliente.getEmail(),cliente.getPassword()));

    }

    @Test
    public void TestValidazioneEmailLogin(){
        Cliente cliente = new Cliente();
        cliente.setEmail("marcorossi1gmail.com");
        cliente.setPassword("Marco1234!");
        ClienteDAO clienteDaomok = Mockito.mock(ClienteDAO.class);
        Login_Service login_service = new Login_Service();
        login_service.setClienteDao(clienteDaomok);
        when(clienteDaomok.controlloEmail(cliente.getEmail())).thenReturn(false);
        Assert.assertNull((login_service.loginCliente(cliente.getEmail(),cliente.getPassword())));

    }

    @Test

    public void TestValidazioneLogin(){
        Cliente cliente = new Cliente();
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");

        Login_Service login_service = new Login_Service();
        ClienteDAO clienteDaomok = Mockito.mock(ClienteDAO.class);
        login_service.setClienteDao(clienteDaomok);
        when(clienteDaomok.controlloEmail(cliente.getEmail())).thenReturn(true);
        when(clienteDaomok.controlloLogin(cliente.getEmail(),cliente.getPassword())).thenReturn(cliente);
        Assert.assertNotNull(login_service.loginCliente(cliente.getEmail(),cliente.getPassword()));

    }
}
