package Storage.DAO.Carrello;

import LogicTier.Oggetti.Carrello;
import Storage.ConPool;

import java.sql.*;

public class CarrelloDAO {
    public int creaNuovoCarrello() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carrello (Numeroelementi,totaleTemporaneo) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, 0.00);
            ps.setInt(2, 0);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE CREAZIONE CARRELLO.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Carrello recuperaCarrello(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT carrelloId,numeroelementi,totaleTemporaneo FROM carrello WHERE carrelloId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Carrello carrello  =new Carrello();
                carrello.setCarrelloId(rs.getInt(1));
                carrello.setNumeroElementi(rs.getInt(2));
                carrello.setTotaleTemporaneo(rs.getDouble(3));
                return carrello;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AggiornaCarrello(Carrello carrello){

        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update carrello set totaleTemporaneo='" + carrello.getTotaleTemporaneo() + "', Numeroelementi=" + carrello.getNumeroElementi()+ " where carrelloId=" + carrello.getCarrelloId() + ";";
            st.executeUpdate(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
