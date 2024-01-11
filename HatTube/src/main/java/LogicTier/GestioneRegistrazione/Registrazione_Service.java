package LogicTier.GestioneRegistrazione;

import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;
import Storage.DAO.Carrello.CarrelloDao;
import Storage.DAO.MetodoPagamento.MetodoPagamentoDao;
import Storage.DAO.Utente.ClienteDao;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrazione_Service implements Registrazione_Interfaccia {

    private Logger logger = Logger.getLogger(Registrazione_Interfaccia.class.getName());

    @Override
    public boolean ValidaNome(String name) {
        String reg = "[a-zA-Z]{1,20}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE NOME NON VALIDO");
            return false;
        } else {

            return true;
        }

    }

    @Override
    public boolean ValidaCognome(String cognome) {
        String reg = "[a-zA-Z]{1,20}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(cognome);

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE COGNOME NON VALIDO");
            return false;
        } else {

            return true;
        }

    }

    @Override
    public boolean ValidaCitta(String citta) {
        String reg = "[a-zA-Z]{1,20}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(citta);

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE CITTA NON VALIDA");
            return false;
        } else {

            return true;
        }

    }

    @Override
    public boolean ValidaVia(String via) {
        String reg = "[a-zA-Z0-9\\s]{1,20}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(via);

        if (!matcher.matches()) {
            logger.log(Level.SEVERE, "ERRORE VIA NON VALIDA");
            return false;
        } else {

            return true;
        }

    }

    @Override
    public boolean ValidaCap(String cap) {
        String regex = "[0-9]{5}";
        String value = String.valueOf(cap);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE CAP NON VALIDO");
            return false;
        }

    }

    @Override
    public boolean ValidaNumCarta(String numcarta) {
        String regex = "[0-9]{16}";
        String value = String.valueOf(numcarta);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE NUM CARTA NON VALIDO");
            return false;
        }

    }

    @Override
    public boolean ValidaCVV(int cvv) {
        String regex = "[0-9]{3}";
        String value = String.valueOf(cvv);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE NUM CVV NON VALIDO");
            return false;
        }

    }

    @Override
    public boolean ValidaNomeI(String nomei) {
        String regex = "[a-zA-Z\\s]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nomei);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE NOME INTESTATARIO NON VALIDO");
            return false;
        }
    }

    @Override
    public boolean ValidaData(String data) {

        if (data != null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean ValidaEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE EMAIL  NON VALIDA");
            return false;
        }

    }

    @Override
    public boolean ValidaPassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[?!@#$%^&+=.,])(?=\\S+$).{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE PASSWORD  NON VALIDA ");
            return false;
        }
    }

    @Override
    public boolean ValidaUsername(String username){
        String regex = "[a-zA-Z0-9] {1,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        if (matcher.matches()) {
            return true;
        } else {
            logger.log(Level.SEVERE, "ERRORE USERNAME  NON VALIDO ");
            return false;
        }
    }

    @Override
    public Cliente SalvaCliente(MetodoPagamento metodoPagamento, Cliente cliente) {
        ClienteDao clienteDao = new ClienteDao();

        MetodoPagamentoDao metodoPagamentoDao = new MetodoPagamentoDao();
        int id = metodoPagamentoDao.SalvaMetodoPagamento(metodoPagamento);    //crea nel db la carta e ritorna la chiave che verrà messa in id
        MetodoPagamento nuovoMetodoPagamento = metodoPagamentoDao.RecuperaMetodoPagamento(id);
        //salva l'id nel numero carta
        cliente.setMetodoPagamento(nuovoMetodoPagamento);
        CarrelloDao cd = new CarrelloDao();
        int idCarrello = cd.creaNuovoCarrello();        //crea nel db il carrello e ritorna la chiave che verrà messa in idCarrello
        Carrello carrello = cd.recuperaCarrello(idCarrello);
        cliente.setCarrello(carrello);

        clienteDao.SalvaCliente(cliente);
        return cliente;
    }


}