package Storage.DAO.MetodoPagamento;

import LogicTier.Oggetti.MetodoPagamento;
import Storage.ConPool;

import java.sql.*;

public class MetodoPagamentoDAO {
    public int SalvaMetodoPagamento(MetodoPagamento carta) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO metodopagamento (NumeroDiCarta, Intestatario, CVV, DataScadenza) VALUES(?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, carta.getNumcarta());
            ps.setString(2, carta.getIntestatario());
            ps.setInt(3, carta.getCvv());
            ps.setString(4, carta.getDataScadenza());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("ERRORE SALVATAGGIO METODO PAGAMENTO!");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public MetodoPagamento RecuperaMetodoPagamento (int id) {

            try (Connection con = ConPool.getConnection()) {
                PreparedStatement ps =
                        con.prepareStatement("SELECT * FROM metodopagamento WHERE id=?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    MetodoPagamento metodoPagamento =new MetodoPagamento();
                    metodoPagamento.setId(Integer.parseInt(rs.getString(1)));
                    metodoPagamento.setNumcarta(rs.getString(2));
                    metodoPagamento.setIntestatario(rs.getString(3));
                    metodoPagamento.setCvv(Integer.parseInt(rs.getString(4)));
                    metodoPagamento.setDataScadenza(rs.getString(5));
                    return metodoPagamento;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

