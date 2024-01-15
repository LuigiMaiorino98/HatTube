package LogicTier.GestioneRegistrazione;

import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;
import Storage.DAO.Carrello.CarrelloDAO;
import Storage.DAO.MetodoPagamento.MetodoPagamentoDAO;
import Storage.DAO.Utente.ClienteDAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrazione_Service implements Registrazione_Interfaccia {

    private Logger logger = Logger.getLogger(Registrazione_Interfaccia.class.getName());

    public boolean validaRegistrazione(Cliente cliente ,MetodoPagamento metodoPagamento) {

        String regemail ="^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        Pattern pattern = Pattern.compile(regemail);
        Matcher matcher = pattern.matcher(cliente.getEmail());

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE EMAIL  NON VALIDA");
            return false;
        }


        String reg = "[a-zA-Z]{1,20}";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(cliente.getNome());

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE NOME NON VALIDO");
            return false;
        }


        reg = "[a-zA-Z]{1,20}";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(cliente.getCognome());

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE COGNOME NON VALIDO");
            return false;
        }


        reg = "[a-zA-Z]{1,20}";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(cliente.getCitta());

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE CITTA NON VALIDA");
            return false;
        }


        reg = "[a-zA-Z0-9\\s]{1,20}";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(cliente.getVia());

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE VIA NON VALIDA");
            return false;
        }


        reg = "[0-9]{5}";
        String value = String.valueOf(cliente.getCAP());
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE CAP NON VALIDO");
            return false;
        }


        String regex = "[0-9]{16}";
        value = String.valueOf(metodoPagamento.getNumcarta());
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE NUM CARTA NON VALIDO");
            return false;
        }


        regex = "[0-9]{3}";
        value = String.valueOf(metodoPagamento.getCvv());
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE NUM CVV NON VALIDO");
            return false;
        }


        regex = "[a-zA-Z\\s]+";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(metodoPagamento.getIntestatario());

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE NOME INTESTATARIO NON VALIDO");
            return false;
        }


        if (metodoPagamento.getDataScadenza().length()<7) {
            logger.log(Level.SEVERE,"ERRORE DATA NON VALIDA");
            return false;
        }





        regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[?!@#$%^&+=.,])(?=\\S+$).{8,}";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(cliente.getPassword());

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE PASSWORD  NON VALIDA ");
            return false;
        }


        regex = "[a-zA-Z0-9]{1,20}";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(cliente.getUsername());

        if (!matcher.matches()) {

            logger.log(Level.SEVERE, "ERRORE USERNAME  NON VALIDO ");
            return false;
        }
        return true;
    }




    @Override
    public Cliente salvaCliente(MetodoPagamento metodoPagamento, Cliente cliente) {
        ClienteDAO clienteDao = new ClienteDAO();

        MetodoPagamentoDAO metodoPagamentoDao = new MetodoPagamentoDAO();
        int id = metodoPagamentoDao.SalvaMetodoPagamento(metodoPagamento);    //crea nel db la carta e ritorna la chiave che verrà messa in id
        MetodoPagamento nuovoMetodoPagamento = metodoPagamentoDao.RecuperaMetodoPagamento(id);
        //salva l'id nel numero carta
        cliente.setMetodoPagamento(nuovoMetodoPagamento);
        CarrelloDAO cd = new CarrelloDAO();
        int idCarrello = cd.creaNuovoCarrello();        //crea nel db il carrello e ritorna la chiave che verrà messa in idCarrello
        Carrello carrello = cd.recuperaCarrello(idCarrello);
        cliente.setCarrello(carrello);

        clienteDao.SalvaCliente(cliente);
        return cliente;
    }


}
