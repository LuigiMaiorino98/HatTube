package Storage.DAO.ContenutoAcquisto;

import LogicTier.Oggetti.Cappello;
import Storage.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class ContenutoAcquistoDAO {

    public ArrayList<Cappello> recuperaContenutoAcquisti(int idAcquisto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,marca,Tipo,Modello,prezzo,quantita FROM ContenutoAcquisto WHERE idAcquisto=?");

            ps.setInt(1,idAcquisto);
            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> cappelli= new ArrayList<>();

            while (rs.next()) {
                Cappello cappello=new Cappello();
                cappello.setCodice(rs.getInt(1));
                cappello.setMarca(rs.getString(2));
                cappello.setCategoria(rs.getString(3));
                cappello.setModello(rs.getString(4));
                cappello.setPrezzo(rs.getDouble(5));
                cappello.setQuantita(rs.getInt(6));
                cappelli.add(cappello);
            }
            return cappelli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserisciInAcquisto(int acquisto, Cappello cappello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ContenutoAcquisto (idAcquisto,marca,Tipo,Modello,prezzo,quantita) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);


            ps.setInt(1, acquisto);
            ps.setString(2, cappello.getMarca());
            ps.setString(3, cappello.getCategoria());
            ps.setString(4, cappello.getModello());
            ps.setDouble(5, cappello.getPrezzo());
            ps.setInt(6, cappello.getQuantita());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("CAPPELLO NON AGGIUNTO ALL'ACQUISTO");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
