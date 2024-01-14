package Storage.DAO.Cappello;


import LogicTier.Oggetti.Cappello;
import Storage.ConPool;

import java.sql.*;
import java.util.ArrayList;

public class CappelloDAO {
    public ArrayList<Cappello>  recuperaCappelli() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Cappello");

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> cappelli = new ArrayList<>();
            while (rs.next()) {
                Cappello cappello = new Cappello();
                cappello.setCodice(rs.getInt(1));
                cappello.setDescrizione(rs.getString(2));
                cappello.setPrezzo(rs.getDouble(3));
                cappello.setMarca(rs.getString(4));
                cappello.setCategoria(rs.getString(5));
                cappello.setModello(rs.getString(6));
                cappello.setQuantita(rs.getInt(7));
                cappello.setImmagine(rs.getString(8));
                cappelli.add(cappello);
            }
            return cappelli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cappello> RecuperaCappelliPerCategoria(String categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Cappello WHERE Tipo=?");
            ps.setString(1, categoria);

            ResultSet rs = ps.executeQuery();
            ArrayList<Cappello> cappelli = new ArrayList<>();
            while (rs.next()) {
                Cappello cappello = new Cappello();
                cappello.setCodice(rs.getInt(1));
                cappello.setDescrizione(rs.getString(2));
                cappello.setPrezzo(rs.getDouble(3));
                cappello.setMarca(rs.getString(4));
                cappello.setCategoria(rs.getString(5));
                cappello.setModello(rs.getString(6));
                cappello.setQuantita(rs.getInt(7));
                cappello.setImmagine(rs.getString(8));
                cappelli.add(cappello);
            }
            return cappelli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cappello RecuperaCappelloID(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice, Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine FROM Cappello WHERE Codice=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cappello cappello = new Cappello();
                cappello.setCodice(rs.getInt(1));
               cappello.setDescrizione(rs.getString(2));
                cappello.setPrezzo(rs.getDouble(3));
                cappello.setMarca(rs.getString(4));
                cappello.setCategoria(rs.getString(5));
                cappello.setModello(rs.getString(6));
                cappello.setQuantita(rs.getInt(7));
                cappello.setImmagine(rs.getString(8));
                return cappello;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cappello trovaCappello(Cappello cappello1) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT Codice, Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine FROM cappello WHERE Tipo=? and Marca=? and Modello=?");
            ps.setString(1, cappello1.getCategoria());
            ps.setString(2, cappello1.getMarca());
            ps.setString(3, cappello1.getModello());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cappello cappello = new Cappello();
                cappello.setCodice(rs.getInt(1));
                cappello.setDescrizione(rs.getString(2));
                cappello.setPrezzo(rs.getDouble(3));
                cappello.setMarca(rs.getString(4));
                cappello.setCategoria(rs.getString(5));
                cappello.setModello(rs.getString(6));
                cappello.setQuantita(rs.getInt(7));
                cappello.setImmagine(rs.getString(8));
                return cappello;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }









    public void decrementaCappello(Cappello cappello) {
        try (Connection con = ConPool.getConnection()) {

         {
                if(cappello.getQuantita()>=1) {
                    PreparedStatement ps = con.prepareStatement(
                            "UPDATE cappello SET Quantita=?  WHERE codice=?  ");

                    ps.setInt(1, cappello.getQuantita() - 1);
                    ps.setInt(2, cappello.getCodice());


                    if (ps.executeUpdate() != 1) {
                        throw new RuntimeException("Errore Rimozione -1.");
                    }
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void aggiornaCappello(Cappello cappello){

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE cappello SET Descrizione = ?,Tipo=?,Prezzo = ?,Modello=?,Quantita=? ,Marca=? WHERE Codice = ?");
            ps.setString(1,cappello.getDescrizione());
            ps.setString(2,cappello.getCategoria());
            ps.setDouble(3,cappello.getPrezzo());
            ps.setString(4,cappello.getModello());
            ps.setInt(5,cappello.getQuantita());
            ps.setString(6,cappello.getMarca());
            ps.setInt(7,cappello.getCodice());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore Update.");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int inserisciCappello(Cappello cappello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO cappello (Descrizione, Prezzo, Marca,Tipo,Modello,Quantita,Immagine) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,cappello.getDescrizione());
            ps.setDouble(2,cappello.getPrezzo());
            ps.setString(3,cappello.getMarca());
            ps.setString(4,cappello.getCategoria());
            ps.setString(5,cappello.getModello());
            ps.setInt(6,cappello.getQuantita());
            ps.setString(7,cappello.getImmagine());

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


    public void rimuoviCappello(Cappello cappello) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM cappello " +
                            "WHERE Codice =?");

            ps.setInt(1, cappello.getCodice());


            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore rimozione Cappello.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

