package sah;

abstract class PiesaSah {
    String numePiesa = new String();
    int x1 = 0;
    int y1 = 0;

    abstract void mutaPiesa(int x2, int y2, PiesaSah[][] tabla);

    public String getNumePiesa() {
        return numePiesa;
    }

    public void setNumePiesa(String numePiesa) {
        this.numePiesa = numePiesa;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

}
