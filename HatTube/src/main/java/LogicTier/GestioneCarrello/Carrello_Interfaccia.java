package LogicTier.GestioneCarrello;

import LogicTier.Oggetti.Acquisto;
import LogicTier.Oggetti.Cappello;
import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;

public interface Carrello_Interfaccia {


   void aggiungiCarrello(Cliente cliente, Cappello cappello);
   Carrello svuotaCarrello(Cliente cliente);
   Carrello rimuoviCappello(Cliente cliente, int id);
   public Acquisto confermaAcquisto(Cliente cliente);

   public Carrello recuperaCarrello(int idCarrello);

}
