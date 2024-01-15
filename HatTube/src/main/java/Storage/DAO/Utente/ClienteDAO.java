package Storage.DAO.Utente;

import LogicTier.Oggetti.Carrello;
import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;
import Storage.ConPool;
import Storage.DAO.Carrello.CarrelloDAO;
import Storage.DAO.MetodoPagamento.MetodoPagamentoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class ClienteDAO {
    public void SalvaCliente(Cliente cliente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO cliente (Email,Password,Nome,Cognome,CAP,Via,Citta,IDCarta,IDCarrello ,username) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,cliente.getEmail());
            ps.setString(2,cliente.getPassword());
            ps.setString(3,cliente.getNome());
            ps.setString(4,cliente.getCognome());
            ps.setString(5,cliente.getCAP());
            ps.setString(6,cliente.getVia());
            ps.setString(7,cliente.getCitta());
            ps.setInt(8,cliente.getMetodoPagamento().getId());
            ps.setInt(9,cliente.getCarrello().getCarrelloId());
            ps.setString(10,cliente.getUsername());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE SALVATAGGIO NUOVO CLIENTE");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Cliente controlloLogin(String email, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM cliente where Password=? and Email=?");
            ps.setString(1,password);
            ps.setString(2,email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                Cliente cliente=new Cliente();
                cliente.setEmail(rs.getString(1));
                cliente.setPassword(rs.getString(2));
                cliente.setNome(rs.getString(3));
                cliente.setCognome(rs.getString(4));
                cliente.setCAP(rs.getString(5));
                cliente.setVia(rs.getString(6));
                cliente.setCitta(rs.getString(7));
                MetodoPagamentoDAO metodoPagamentoDao = new MetodoPagamentoDAO();
                MetodoPagamento metodoPagamento = metodoPagamentoDao.RecuperaMetodoPagamento(rs.getInt(8));
                cliente.setMetodoPagamento(metodoPagamento);
                CarrelloDAO carrelloDao = new CarrelloDAO();
                Carrello carrello = carrelloDao.recuperaCarrello(rs.getInt(9));

                cliente.setCarrello(carrello);
                cliente.setUsername(rs.getString(10));

                return cliente;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Boolean controlloEmail(String email) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM cliente where  Email=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* public Boolean controlloAdmin(String email,String password) {
               if(email.equals("sasa@hattube.com") && password.equals("Ciao12345!"))
                   return true;
               else if(email.equals("gmaior@hattube.com") && password.equals("Addio12345!")){
                   return  true;
             }
             else {
                 return false;
               }
        } */

}

