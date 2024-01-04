package LogicTier.Oggetti;

import java.util.ArrayList;

public class Acquisto {
    private int id;
    private double prezzo=0.00;
    private int carrello;

    ArrayList<Cappello> cappelli =new ArrayList<>();

    public ArrayList<Cappello> getCappelli() {
        return cappelli;
    }

    public void setCappelli(ArrayList<Cappello> cappelli) {
        this.cappelli = cappelli;
    }

    public int getCarrello() {
        return carrello;
    }

    public void setCarrello(int carrello) {
        this.carrello = carrello;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }



}
