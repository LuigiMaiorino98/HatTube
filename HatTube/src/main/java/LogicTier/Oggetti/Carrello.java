package LogicTier.Oggetti;

import java.util.ArrayList;

public class Carrello {
    private int carrelloId;
    private double totaleTemporaneo = 0.00;
    private int numeroElementi = 0;

    ArrayList<Cappello> prodotti = new ArrayList<>();

    public ArrayList<Cappello> getProdotti() {
        return prodotti;
    }

    public void setProdotti(ArrayList<Cappello> prodotti) {
        this.prodotti = prodotti;
    }

    public void aggiungiProdotto(Cappello hat) {
        this.prodotti.add(hat);
        this.totaleTemporaneo += hat.getPrezzo();
        this.numeroElementi = this.numeroElementi + 1;
    }

    public Cappello rimuoviCappelloUtente(int pos){
        if(pos>=0) {
            Cappello cappello= this.prodotti.remove(pos);
            this.totaleTemporaneo = totaleTemporaneo - cappello.getPrezzo();
            this.numeroElementi -= cappello.getQuantita();
            return cappello;
        }
        else {
            return null;
        }
    }

    public Cappello rimuoviProdotto(int pos) {
        if (pos >= 0) {
            for (Cappello cappello : this.prodotti) {
                if (cappello.getCodice() == pos) {
                    this.prodotti.remove(cappello);
                    this.totaleTemporaneo = totaleTemporaneo - cappello.getPrezzo();
                    this.numeroElementi -= 1;
                    return cappello;
                }
            }

        }
        return null;
    }




    public int getCarrelloId() {
        return carrelloId;
    }

    public void setCarrelloId(int carrelloId) {
        this.carrelloId = carrelloId;
    }

    public double getTotaleTemporaneo() {
        return totaleTemporaneo;
    }

    public void setTotaleTemporaneo(double totaleTemporaneo) {
        this.totaleTemporaneo = totaleTemporaneo;
    }

    public int getNumeroElementi() {
        return numeroElementi;
    }

    public void setNumeroElementi(int numeroElementi) {
        this.numeroElementi = numeroElementi;
    }
}
