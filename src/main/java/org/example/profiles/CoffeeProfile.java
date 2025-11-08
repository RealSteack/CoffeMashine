package org.example.profiles;

public class CoffeeProfile {
    public int coupCountEspresso;
    public int coupCountCappuccino;

    public CoffeeProfile(int coupCountEspresso, int coupCountCappuccino) {
        this.coupCountEspresso = coupCountEspresso;
        this.coupCountCappuccino = coupCountCappuccino;
    }

    public int getCoupCountEspresso() {
        return coupCountEspresso;
    }

    public void setCoupCountEspresso(int coupCountEspresso) {
        this.coupCountEspresso = coupCountEspresso;
    }

    public int getCoupCountCappuccino() {
        return coupCountCappuccino;
    }

    public void setCoupCountCappuccino(int coupCountCappuccino) {
        this.coupCountCappuccino = coupCountCappuccino;
    }
}