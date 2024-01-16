package LogicTier.GestioneAdmin;

import LogicTier.Oggetti.Acquisto;
import LogicTier.Oggetti.Cappello;
import Storage.DAO.Acquisto.AcquistoDAO;
import Storage.DAO.Cappello.CappelloDAO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin_Service implements Admin_Interfaccia{
    private Logger logger = Logger.getLogger(Admin_Interfaccia.class.getName());
    @Override
    public void aggiungiCappello(Cappello cappello ){
        CappelloDAO cappelloDAO = new CappelloDAO();
        cappelloDAO.inserisciCappello(cappello);
    }

    @Override
    public void eliminaCappello(int codice){
        CappelloDAO cappelloDAO = new CappelloDAO();
        Cappello cappello = cappelloDAO.recuperaCappelloID(codice);
        CappelloDAO cappelloDao = new CappelloDAO();
        cappelloDao.rimuoviCappello(cappello);

    }

    @Override
    public void modificaCappello(Cappello cappello){
        CappelloDAO cappelloDAO = new CappelloDAO();
        cappelloDAO.aggiornaCappello(cappello);
    }


    public boolean modificaCappelloValidazione(Cappello cappello){
        if (cappello.getDescrizione().length() == 0 || cappello.getDescrizione().length() > 100) {
            logger.log(Level.SEVERE, "ERRORE DESCRIZIONE  NON VALIDA");
           return false;
        } else if (cappello.getPrezzo()<=0.99 ) {
            logger.log(Level.SEVERE, "ERRORE PREZZO  NON VALIDA");
            return false;
        } else if (cappello.getMarca().length()==0 || cappello.getMarca().length()>20){
            logger.log(Level.SEVERE, "ERRORE MARCA  NON VALIDA");
            return false;
        }else if (cappello.getModello().length()==0 || cappello.getModello().length()>20){
            logger.log(Level.SEVERE, "ERRORE MODELLO  NON VALIDA");
            return false;
        }else if(cappello.getQuantita()<=0 || cappello.getQuantita()>10000){
            logger.log(Level.SEVERE, "ERRORE QUANTITA  NON VALIDA");
            return false;
        }else if(!cappello.getCategoria().equals("Baseball") && !cappello.getCategoria().equals("Lana")&& !cappello.getCategoria().equals("Pesca")){
            logger.log(Level.SEVERE, "ERRORE CATEGORIA  NON VALIDA");
            return false;}

        modificaCappello(cappello);
        return true;
    }

    @Override
    public boolean addCappelloValidazione(Cappello cappello){
        if (cappello.getDescrizione().length() == 0 || cappello.getDescrizione().length() > 100) {
            logger.log(Level.SEVERE, "ERRORE DESCRIZIONE  NON VALIDA");
            return false;
        } else if (cappello.getPrezzo()<=0.99 ) {
            logger.log(Level.SEVERE, "ERRORE PREZZO  NON VALIDA");
            return false;
        } else if (cappello.getMarca().length()==0 || cappello.getMarca().length()>20){
            logger.log(Level.SEVERE, "ERRORE MARCA  NON VALIDA");
            return false;
        }else if (cappello.getModello().length()==0 || cappello.getModello().length()>20){
            logger.log(Level.SEVERE, "ERRORE MODELLO  NON VALIDA");
            return false;
        }else if(cappello.getQuantita()<=0 || cappello.getQuantita()>10000){
            logger.log(Level.SEVERE, "ERRORE QUANTITA  NON VALIDA");
            return false;
        }
        else if(cappello.getImmagine().length()==0 || cappello.getImmagine().length()>50){
            logger.log(Level.SEVERE, "ERRORE IMMAGINE  NON VALIDA");
            return false;
        }else if(!cappello.getCategoria().equals("Baseball") && !cappello.getCategoria().equals("Lana")&& !cappello.getCategoria().equals("Pesca")){
            logger.log(Level.SEVERE, "ERRORE CATEGORIA  NON VALIDA");
            return false;
        }
        aggiungiCappello(cappello);
        return true;
    }


    @Override
    public ArrayList<Acquisto> recuperaAcquisti(){

        AcquistoDAO acquistoDao= new AcquistoDAO();

        ArrayList<Acquisto> acquisti =acquistoDao.recuperaAcquisti();

        return acquisti;
    }


}
