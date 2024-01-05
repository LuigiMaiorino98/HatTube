package LogicTier.GestioneCappelli;

import LogicTier.Oggetti.Cappello;

import java.util.ArrayList;

public interface Cappelli_Interfaccia {


    Cappello recuperaCappello(int id);

    ArrayList<Cappello> recuperaCategoria(String categoria);

    ArrayList<Cappello> recuperaTutti();


}
