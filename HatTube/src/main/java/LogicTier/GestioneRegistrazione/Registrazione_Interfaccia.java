package LogicTier.GestioneRegistrazione;

import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;

public interface Registrazione_Interfaccia {

     public boolean validaRegistrazione(Cliente cliente , MetodoPagamento metodoPagamento);
     public Cliente salvaCliente(MetodoPagamento metodoPagamento ,  Cliente cliente);
}
