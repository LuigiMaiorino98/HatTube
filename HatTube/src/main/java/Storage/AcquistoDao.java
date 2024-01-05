package Storage.Acquisto;

import LogicTier.Oggetti.Cappello;
import Storage.ConPool;
import Storage.Cappello.Cappello;

import java.sql.*;
import java.util.ArrayList;

public class AcquistoDao {

    public int nuovoAcquisto(int carrelloId) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Acquisto (Carrello,prezzo) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carrelloId);
            ps.setDouble(2, 0.00);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE CREAZIONE ACQUISTO.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void AggiornaAcquisto(double prezzo,int id){

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update Acquisto set  prezzo=" + prezzo+ " where id=" + id + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Cappello> recuperaContenutoAcquisto(int idAcquisto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,marca,Tipo,Modello,prezzo,quantita FROM ContenutoAcquisto WHERE idAcquisto=?");

            ps.setInt(1, idAcquisto);

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> hats = new ArrayList<>();
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
}
