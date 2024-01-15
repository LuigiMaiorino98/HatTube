package Storage.DAO.Acquisto;

import LogicTier.Oggetti.Acquisto;
import Storage.ConPool;
import Storage.DAO.ContenutoAcquisto.ContenutoAcquistoDAO;

import java.sql.*;
import java.util.ArrayList;

public class AcquistoDAO {

    public int nuovoAcquisto(int carrelloId) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO acquisto (Carrello,prezzo) VALUES(?,?)",
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
            String query = "update acquisto set  prezzo=" + prezzo+ " where id=" + id + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public ArrayList<Acquisto> recuperaAcquisti() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Acquisto");

            ResultSet rs = ps.executeQuery();
            ArrayList<Acquisto> acquisti=new ArrayList<>();
            ContenutoAcquistoDAO contenutoAcquistoDAO=new ContenutoAcquistoDAO();

            while (rs.next()) {
                Acquisto acquisto=new Acquisto();
                acquisto.setId(rs.getInt(1));
                acquisto.setCarrello(rs.getInt(2));
                acquisto.setPrezzo(rs.getDouble(3));
                acquisto.setCappelli(contenutoAcquistoDAO.recuperaContenutoAcquisti(acquisto.getId()));
                acquisti.add(acquisto);
            }
            return acquisti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
