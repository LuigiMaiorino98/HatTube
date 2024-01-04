package LogicTier.Oggetti;

public class Cliente extends Utente {


    private String citta;
    private String via;
    private String CAP;
    private MetodoPagamento metodoPagamento;
    private Carrello carrello;


    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getCAP() {
        return CAP;
    }
    public void setCAP(String CAP) {
        this.CAP = CAP;
    }
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

}
