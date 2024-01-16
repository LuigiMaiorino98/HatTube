package LogicTier.GestioneCarrello;

import LogicTier.Oggetti.Acquisto;
import LogicTier.Oggetti.Cappello;
import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;
import Storage.DAO.Acquisto.AcquistoDAO;
import Storage.DAO.Cappello.CappelloDAO;
import Storage.DAO.Carrello.CarrelloDAO;
import Storage.DAO.Contenere.ContenereDAO;
import Storage.DAO.ContenutoAcquisto.ContenutoAcquistoDAO;

import java.util.ArrayList;

public class Carrello_Service implements Carrello_Interfaccia{


    @Override
    public void aggiungiCarrello(Cliente cliente, Cappello cappello) {
        CarrelloDAO carrelloDAO = new CarrelloDAO();
        Carrello carrello = carrelloDAO.recuperaCarrello(cliente.getCarrello().getCarrelloId());

        carrello.aggiungiProdotto(cappello);
        ContenereDAO contentereDAO = new ContenereDAO();

        contentereDAO.inserisciNelCarrello(cliente.getCarrello().getCarrelloId(), cappello);
        carrelloDAO.AggiornaCarrello(carrello);

    }

    @Override
    public Carrello svuotaCarrello(Cliente cliente) {
        CarrelloDAO carrelloDAO = new CarrelloDAO();
        Carrello carrello = carrelloDAO.recuperaCarrello(cliente.getCarrello().getCarrelloId());
        ContenereDAO contentereDAO = new ContenereDAO();

        ArrayList<Cappello> cappelli = contentereDAO.recuperaContenuto(carrello.getCarrelloId());
        carrello.setProdotti(cappelli);

        for (Cappello cappello : cappelli) {
            contentereDAO.rimuoviContenuto(carrello.getCarrelloId(), cappello.getCodice());
        }
        carrello.setTotaleTemporaneo(0);
        carrello.getProdotti().clear();
        carrello.setNumeroElementi(0);
        carrelloDAO.AggiornaCarrello(carrello);
        return carrello;

    }

    @Override
    public Carrello rimuoviCappello(Cliente cliente, int id) {
        CarrelloDAO carrelloDAO = new CarrelloDAO();
        Carrello carrello = carrelloDAO.recuperaCarrello(cliente.getCarrello().getCarrelloId());
        ContenereDAO contentereDAO = new ContenereDAO();

        ArrayList<Cappello> cappelli = contentereDAO.recuperaContenuto(carrello.getCarrelloId());
        carrello.setProdotti(cappelli);
        Cappello cappello = carrello.rimuoviProdotto(id);
        carrelloDAO.AggiornaCarrello(carrello);

        contentereDAO.rimuoviContenuto(carrello.getCarrelloId(), cappello.getCodice());
        return carrello;
    }


    @Override
    public Acquisto confermaAcquisto(Cliente cliente) {
        CarrelloDAO carrelloDAO = new CarrelloDAO();
        Carrello carrello = carrelloDAO.recuperaCarrello(cliente.getCarrello().getCarrelloId());
        ContenereDAO contentereDAO = new ContenereDAO();
        ArrayList<Cappello> cappelli = contentereDAO.recuperaContenuto(carrello.getCarrelloId());

        CappelloDAO cappelloDAO = new CappelloDAO();


        if (carrello.getTotaleTemporaneo() > 0.00) {

            AcquistoDAO acquistoDao = new AcquistoDAO();
            int id = acquistoDao.nuovoAcquisto(cliente.getCarrello().getCarrelloId());
            Acquisto acquisto = new Acquisto();
            acquisto.setId(id);

            ContenutoAcquistoDAO contenutoAcquistoDAO = new ContenutoAcquistoDAO();
            for (Cappello cappello : cappelli) {
                Cappello cappelloDaDecrementare = cappelloDAO.trovaCappello(cappello);
                cappelloDAO.decrementaCappello(cappelloDaDecrementare);
                contentereDAO.rimuoviContenuto(carrello.getCarrelloId(), cappello.getCodice());
                contenutoAcquistoDAO.inserisciInAcquisto(id, cappello);
            }

            acquisto.setPrezzo(carrello.getTotaleTemporaneo());
            acquistoDao.aggiornaAcquisto(carrello.getTotaleTemporaneo(), acquisto.getId());
            carrello.setTotaleTemporaneo(0.00);
            carrello.setNumeroElementi(0);
            carrelloDAO.AggiornaCarrello(carrello);
            return acquisto;


        }
        return null;
    }


    @Override
    public Carrello recuperaCarrello(int idCarrello){
        CarrelloDAO carrelloDAO=new CarrelloDAO();
        Carrello carrello=carrelloDAO.recuperaCarrello(idCarrello);

        ContenereDAO contentereDAO=new ContenereDAO();                                   //recupero il contenuto del carrello e lo carico all'interno
        carrello.setProdotti(contentereDAO.recuperaContenuto(carrello.getCarrelloId()));  // del carrello dell'utente loggato
        return carrello;
    }
}
