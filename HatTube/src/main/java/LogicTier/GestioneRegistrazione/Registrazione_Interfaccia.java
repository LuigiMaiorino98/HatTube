package LogicTier.GestioneRegistrazione;

import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;

public interface Registrazione_Interfaccia {

     boolean ValidaNome(String nome);
     boolean ValidaCognome(String cognome);

     boolean ValidaCitta(String citta);

     boolean ValidaVia(String via);

     boolean ValidaCap(String cap);

     boolean ValidaNumCarta(String numcarta);

     boolean ValidaCVV(int cvv);

     boolean ValidaNomeI(String nomei);

     boolean ValidaData (String data);

     boolean ValidaEmail(String email );

     boolean ValidaPassword(String password);

     boolean ValidaUsername(String username);

     Cliente SalvaCliente(MetodoPagamento metodoPagamento , Cliente cliente);
}
