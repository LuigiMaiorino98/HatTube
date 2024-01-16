package LogicTier.GestioneCappelli;
import LogicTier.Oggetti.Cappello;
import Storage.DAO.Cappello.CappelloDAO;

import java.util.ArrayList;

public class Cappelli_Service implements Cappelli_Interfaccia {

    @Override
    public Cappello recuperaCappello(int id){
        CappelloDAO daohat= new CappelloDAO();
        Cappello cappello= daohat.recuperaCappelloID(id);
        return cappello;
    }

    @Override
    public ArrayList<Cappello> recuperaCategoria(String categoria){
        CappelloDAO daohat= new CappelloDAO();
        ArrayList<Cappello> cappelli = daohat.recuperaCappelliPerCategoria(categoria);
        return cappelli;
    }

    @Override
    public ArrayList<Cappello> recuperaTutti(){
        CappelloDAO daohat = new CappelloDAO();
        ArrayList<Cappello> cappelli = daohat.recuperaCappelli();
        return cappelli;
    }

}
