package LogicTier.GestioneAutenticazione;

import LogicTier.Oggetti.Admin;
import LogicTier.Oggetti.Cliente;

public interface Login_Interfaccia {

    Cliente loginCliente(String email, String password);
    Admin loginAdmin(String email , String password);

}
