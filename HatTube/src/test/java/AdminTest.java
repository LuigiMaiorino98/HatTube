import LogicTier.GestioneAdmin.Admin_Service;
import LogicTier.Oggetti.Cappello;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest {
    @Test
    public void TestDescrizione(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("");
        cappello.setPrezzo(19.99);
        cappello.setMarca("New Era");
        cappello.setModello("NewYork Red");
        cappello.setQuantita(199);
        cappello.setCategoria("Baseball");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));

    }

    @Test
    public void TestPrezzo(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("Cappello NewYork Red");
        cappello.setPrezzo(0.00);
        cappello.setMarca("New Era");
        cappello.setModello("NewYork Red");
        cappello.setQuantita(199);
        cappello.setCategoria("Baseball");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));


    }
    @Test
    public  void TestMarca(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("Cappello NewYork Red ");
        cappello.setPrezzo(19.99);
        cappello.setMarca("");
        cappello.setModello("NewYork Red");
        cappello.setQuantita(199);
        cappello.setCategoria("Baseball");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));

    }
    @Test
    public void TestModello(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("Cappello NewYork Red ");
        cappello.setPrezzo(19.99);
        cappello.setMarca("New Era");
        cappello.setModello("");
        cappello.setQuantita(199);
        cappello.setCategoria("Baseball");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));

    }
    @Test
    public void TestQuantita(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("Cappello NewYork Red ");
        cappello.setPrezzo(19.99);
        cappello.setMarca("New Era");
        cappello.setModello("NewYork Red");
        cappello.setQuantita(0);
        cappello.setCategoria("Baseball");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));

    }

    @Test
    public void TestCategoria(){
        Cappello cappello = new Cappello();
        cappello.setDescrizione("Cappello NewYork Red ");
        cappello.setPrezzo(19.99);
        cappello.setMarca("New Era");
        cappello.setModello("New York Red");
        cappello.setQuantita(199);
        cappello.setCategoria("");
        Admin_Service admin_service = new Admin_Service();
        Assert.assertFalse(admin_service.modificaCappelloValidazione(cappello));

    }
}
