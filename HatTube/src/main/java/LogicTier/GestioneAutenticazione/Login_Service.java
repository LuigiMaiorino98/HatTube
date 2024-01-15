package LogicTier.GestioneAutenticazione;

import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;
import Storage.DAO.Utente.AdminDAO;
import Storage.DAO.Utente.ClienteDAO;

public class Login_Service implements Login_Interfaccia{



    @Override
    public Cliente loginClienteFacade(String email, String password){
        ClienteDAO clienteDao=new ClienteDAO();
        Cliente cliente = clienteDao.controlloLogin(email, password);
        return cliente;

    }

    @Override
    public Admin loginAdminFacade(String email , String password){
        AdminDAO adminDao = new AdminDAO();
        Admin admin = adminDao.controlloLogin(email, password);
        return admin;
    }


}
