package LogicTier.GestioneAdmin;

import LogicTier.Oggetti.Acquisto;
import LogicTier.Oggetti.Cappello;

import java.util.ArrayList;

public interface Admin_Interfaccia {

    void aggiungiCappello(Cappello cappello );

    void eliminaCappello(int codice);

    void modificaCappello(Cappello cappello);

    boolean modificaCappelloValidazione(Cappello cappello);

    boolean addCappelloValidazione(Cappello cappello);

    public ArrayList<Acquisto> recuperaAcquisti();

}
