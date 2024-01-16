import LogicTier.GestioneRegistrazione.Registrazione_Service;
import LogicTier.Oggetti.Cliente;
import LogicTier.Oggetti.MetodoPagamento;
import org.junit.Assert;
import org.junit.Test;


public  class RegistrazioneControlTest {

    @Test
    public void TestNomeRegistrazione( ){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco$");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();

        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));
    }

    @Test
    public void TestCognomeRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi$");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();

        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));





    }

    @Test
    public void TestCittaRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodos$ola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();

        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));


    }

    @Test
    public void TestViaRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1/");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();

        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));

    }


    @Test
    public void TestCapRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("2884523");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));

    }

    @Test
    public void TestNumCartaRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("12345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));


    }

    @Test
    public void TestCvvRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("1233"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));

    }

    @Test

    public void TestNomeiRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setIntestatario("Marco Ross1");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));



    }
    @Test

    public void TestEmailRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1gmail.com");
        cliente.setPassword("Marco1234!");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));



    }
    @Test
    public void TestPasswordRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));


    }
    @Test
    public void TestUsernameRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("04/2024");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234!");
        cliente.setUsername("Marco£$%");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));

    }
    @Test
    public void TestDataRegistrazione(){
        Cliente cliente = new Cliente();
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        cliente.setNome("Marco");
        cliente.setCognome("Rossi");
        cliente.setCitta("Domodossola");
        cliente.setVia("Via Roma 1");
        cliente.setCAP("28845");
        metodoPagamento.setNumcarta("1234567812345678");
        metodoPagamento.setCvv(Integer.parseInt("123"));
        metodoPagamento.setDataScadenza("");
        metodoPagamento.setIntestatario("Marco Rossi");
        cliente.setEmail("marcorossi1@gmail.com");
        cliente.setPassword("Marco1234");
        cliente.setUsername("Marco£$%");
        Registrazione_Service registrazione_service = new Registrazione_Service();
        Assert.assertFalse(registrazione_service.validaRegistrazione(cliente,metodoPagamento));

    }

}