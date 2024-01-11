package LogicTier.GestioneAutenticazione;

import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;
import Storage.DAO.Utente.AdminDao;
import Storage.DAO.Utente.ClienteDao;

public class Login_Service implements Login_Interfaccia{



    @Override
    public Cliente loginClienteFacade(String email, String password){
        ClienteDao clienteDao=new ClienteDao();
        Cliente cliente = clienteDao.controlloLogin(email, password);
        return cliente;

    }

    @Override
    public Admin loginAdminFacade(String email , String password){
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.controlloLogin(email, password);
        return admin;
    }


}
