package Storage.DAO.Utente;

import LogicTier.Oggetti.Admin;
import Storage.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public Admin controlloLogin(String email, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Admin where Password=? and Email=?");
            ps.setString(1,password);
            ps.setString(2,email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                Admin admin = new Admin();
                admin.setEmail(rs.getString(1));
                admin.setPassword(rs.getString(2));
                admin.setNome(rs.getString(3));
                admin.setCognome(rs.getString(4));
                admin.setUsername(rs.getString(5));
                return admin;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }







    public Boolean controlloAdmin(String email,String password) {
        if(email.equals("sasa@hattube.com") && password.equals("Ciao12345!"))
            return true;
        else if(email.equals("gmaior@hattube.com") && password.equals("Addio12345!")){
            return  true;
        }
        else if(email.equals("bpigna7@hattube.com") && password.equals("MarioRui!7")){
            return  true;
        }
        else {
            return false;
        }
    }


}
