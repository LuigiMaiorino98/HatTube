package LogicTier.GestioneAutenticazione;

import LogicTier.GestioneAdmin.Admin_Interfaccia;
import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;
import Storage.DAO.Utente.AdminDAO;
import Storage.DAO.Utente.AdminDAO;
import Storage.DAO.Utente.ClienteDAO;
import Storage.DAO.Utente.ClienteDAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Service implements Login_Interfaccia {
    private Logger logger = Logger.getLogger(Login_Interfaccia.class.getName());
    public ClienteDAO clienteDao = new ClienteDAO();
    public AdminDAO adminDao = new AdminDAO();

    @Override
    public Cliente loginCliente(String email, String password) {
        String regemail = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        Pattern pattern = Pattern.compile(regemail);
        Matcher matcher = pattern.matcher(email);


        if (!this.clienteDao.controlloEmail(email) || !matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE EMAIL");
            return null;
        }
        String regepas = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[?!@#$%^&+=.,])(?=\\S+$).{8,}";
        pattern = Pattern.compile(regepas);
        matcher = pattern.matcher(password);
        if (this.clienteDao.controlloLogin(email, password) == null || !matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE PASSWORD");
            return null;
        }
        return this.clienteDao.controlloLogin(email, password);
    }


    public ClienteDAO getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public Admin loginAdmin(String email, String password) {

        Admin admin = this.adminDao.controlloLogin(email, password);
        if (admin != null) {
            return admin;
        }
        logger.log(Level.SEVERE, "ERRORE ADMIN LOGIN ");
        return null;

    }


}