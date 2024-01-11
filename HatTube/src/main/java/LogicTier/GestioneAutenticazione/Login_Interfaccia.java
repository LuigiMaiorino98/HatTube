package LogicTier.GestioneAutenticazione;

import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;

public interface Login_Interfaccia {

    Cliente loginClienteFacade(String email, String password);
    Admin loginAdminFacade(String email , String password);

}
