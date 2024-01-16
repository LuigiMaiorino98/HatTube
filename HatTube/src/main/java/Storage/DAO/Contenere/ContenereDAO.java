package Storage.DAO.Contenere;

import LogicTier.Oggetti.Carrello;
import Storage.ConPool;
import LogicTier.Oggetti.Cappello;
import Storage.DAO.Cappello.CappelloDAO;
import Storage.DAO.Carrello.CarrelloDAO;

import java.sql.*;
import java.util.ArrayList;

public class ContenereDAO {



    public void inserisciNelCarrello(int carrello, Cappello cappello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Contenere WHERE idCappello=? and Carrello=?");

            ps.setInt(1, cappello.getCodice());
            ps.setInt(2, carrello);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cappello.setQuantita(cappello.getQuantita() + rs.getInt(4));
                cappello.setPrezzo(cappello.getPrezzo() + rs.getDouble(3));

                ps = con.prepareStatement("update Contenere set prezzo=?,quantita=? where idCappello=? and Carrello=?");
                cappello.setQuantita(cappello.getQuantita());
                ps.setDouble(1, cappello.getPrezzo());
                ps.setInt(2, cappello.getQuantita());
                ps.setInt(3, cappello.getCodice());
                ps.setInt(4, carrello);
            } else {
                ps = con.prepareStatement(
                        "INSERT INTO Contenere(idCappello,Carrello,quantita,prezzo) VALUES(?,?,?,?)");

                ps.setInt(1, cappello.getCodice());
                ps.setInt(2, carrello);
                ps.setInt(3, cappello.getQuantita());
                ps.setDouble(4, cappello.getPrezzo());
            }
            if(ps.executeUpdate()!=1){
                throw new RuntimeException("ERRORE AGGIUNTA AL CONTENERE");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Cappello> recuperaContenuto(int idCarrello) {


        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Contenere WHERE Carrello=?");

            ps.setInt(1, idCarrello);

            ResultSet rs = ps.executeQuery();

            ArrayList<Cappello> cappelli= new ArrayList<>();
            CappelloDAO cappelloDAO=new CappelloDAO();
            CarrelloDAO carrelloDao=new CarrelloDAO();
            Carrello carrello=carrelloDao.recuperaCarrello(idCarrello);
            while (rs.next()) {
                Cappello cappello=cappelloDAO.recuperaCappelloID(rs.getInt(1));
                cappello.setPrezzo(rs.getDouble(3));
                cappello.setQuantita(rs.getInt(4));
                cappelli.add(cappello);
            }

            return cappelli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    public void rimuoviContenuto(int idCarrello,int pos) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Contenere " +
                            "WHERE idCappello =? and Carrello=?");

            ps.setInt(1,pos );
            ps.setInt(2, idCarrello);


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore rimozione");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

