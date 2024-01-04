package LogicTier.Oggetti;

//classe metodopagamento
public class MetodoPagamento {
    private int id;

    private String numcarta;
    private int cvv;
    private String dataScadenza;

    private String intestatario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(String intestatario) {
        this.intestatario = intestatario;
    }


    public String getNumcarta() {
        return numcarta;
    }

    public void setNumcarta(String numcarta) {
        this.numcarta = numcarta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
}
