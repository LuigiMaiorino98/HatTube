package Storage.Cappello;


import LogicTier.Oggetti.Cappello;
import Storage.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class CappelloDAO {
    public ArrayList<Cappello> doRetrieveAllHats() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Cappello");

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> hats = new ArrayList<>();
            while (rs.next()) {
                Cappello hat = new Cappello();
                hat.setCodice(rs.getInt(1));
                hat.setDescrizione(rs.getString(2));
                hat.setPrezzo(rs.getDouble(3));
                hat.setMarca(rs.getString(4));
                hat.setTipo(rs.getString(5));
                hat.setModello(rs.getString(6));
                hat.setQuantita(rs.getInt(7));
                hat.setImmagine(rs.getString(8));
                hats.add(hat);
            }
            return hats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cappello> doRetrieveAllHatsByType(String type) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Cappello WHERE Tipo=?");
            ps.setString(1, type);

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> hats = new ArrayList<>();
            while (rs.next()) {
                Cappello hat = new Cappello();
                hat.setCodice(rs.getInt(1));
                hat.setDescrizione(rs.getString(2));
                hat.setPrezzo(rs.getDouble(3));
                hat.setMarca(rs.getString(4));
                hat.setTipo(rs.getString(5));
                hat.setModello(rs.getString(6));
                hat.setQuantita(rs.getInt(7));
                hat.setImmagine(rs.getString(8));
                hats.add(hat);
            }
            return hats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cappello retriveHatByID(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice, Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine FROM Cappello WHERE Codice=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cappello hat = new Cappello();
                hat.setCodice(rs.getInt(1));
                hat.setDescrizione(rs.getString(2));
                hat.setPrezzo(rs.getDouble(3));
                hat.setMarca(rs.getString(4));
                hat.setTipo(rs.getString(5));
                hat.setModello(rs.getString(6));
                hat.setQuantita(rs.getInt(7));
                hat.setImmagine(rs.getString(8));
                return hat;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cappello trovaCappello(Cappello hat1) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice, Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine FROM Cappello WHERE Tipo=? and Marca=? and Modello=?");
            ps.setString(1, hat1.getTipo());
            ps.setString(2, hat1.getMarca());
            ps.setString(3, hat1.getModello());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cappello hat = new Cappello();
                hat.setCodice(rs.getInt(1));
                hat.setDescrizione(rs.getString(2));
                hat.setPrezzo(rs.getDouble(3));
                hat.setMarca(rs.getString(4));
                hat.setTipo(rs.getString(5));
                hat.setModello(rs.getString(6));
                hat.setQuantita(rs.getInt(7));
                hat.setImmagine(rs.getString(8));
                return hat;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }









    public void decrementaHat(Cappello hat) {
        try (Connection con = ConPool.getConnection()) {

            {
                if(hat.getQuantita()>=1) {
                    PreparedStatement ps = con.prepareStatement(
                            "UPDATE Cappello SET Quantita=?  WHERE codice=?  ");

                    ps.setInt(1, hat.getQuantita() - 1);
                    ps.setInt(2, hat.getCodice());


                    if (ps.executeUpdate() != 1) {
                        throw new RuntimeException("Errore Rimozione -1.");
                    }
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void aggiornaCappello(Cappello hat){

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE Cappello SET Descrizione = ?,Tipo=?,Prezzo = ?,Modello=?,Quantita=? ,Marca=? WHERE Codice = ?");
            ps.setString(1,hat.getDescrizione());
            ps.setString(2,hat.getTipo());
            ps.setDouble(3,hat.getPrezzo());
            ps.setString(4,hat.getModello());
            ps.setInt(5,hat.getQuantita());
            ps.setString(6,hat.getMarca());
            ps.setInt(7,hat.getCodice());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore Update.");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int inserisciProdotto(Cappello hat) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Cappello (Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,hat.getDescrizione());
            ps.setDouble(2,hat.getPrezzo());
            ps.setString(3,hat.getMarca());
            ps.setString(4,hat.getTipo());
            ps.setString(5,hat.getModello());
            ps.setInt(6,hat.getQuantita());
            ps.setString(7,hat.getImmagine());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE CREAZIONE PRODOTTO.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void rimuoviCappello(Cappello hat) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Cappello " +
                            "WHERE Codice =?");

            ps.setInt(1, hat.getCodice());


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore rimozione Cappello.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
