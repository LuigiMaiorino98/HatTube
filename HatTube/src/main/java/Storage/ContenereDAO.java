package Storage.Contenere;

import LogicTier.Oggetti.Cappello;
import Storage.ConPool;
import Storage.Cappello.Cappello;

import java.sql.*;
import java.util.ArrayList;

public class ContenereDAO {
    public void inserisciNelCarrello(int carrello, Cappello hat) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Contenere (Carrello,marca,Tipo,Modello,prezzo,quantita) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);


            ps.setInt(1,carrello);
            ps.setString(2, hat.getMarca());
            ps.setString(3, hat.getTipo());
            ps.setString(4, hat.getModello());
            ps.setDouble(5, hat.getPrezzo());
            ps.setInt(6, hat.getQuantita());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE AGGIUNTA PRODOTTO CARRELLO.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




    public ArrayList<Cappello> recuperaContenuto(int idCarrello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,marca,Tipo,Modello,prezzo,quantita FROM Contenere WHERE Carrello=?");

            ps.setInt(1,idCarrello);

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> hats= new ArrayList<>();
            while (rs.next()) {
                Cappello cappello = new Cappello();
                cappello.setCodice(rs.getInt(1));
                cappello.setMarca(rs.getString(2));
                cappello.setTipo(rs.getString(3));
                cappello.setModello(rs.getString(4));
                cappello.setPrezzo(rs.getDouble(5));
                cappello.setQuantita(rs.getInt(6));
                hats.add(cappello);
            }
            return hats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void rimuoviContenuto(int cartId,int pos) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Contenere " +
                            "WHERE id =? and Carrello=?");

            ps.setInt(1, pos);
            ps.setInt(2, cartId);


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore rimozione.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}