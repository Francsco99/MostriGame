public class Mostro {
    private String nome;
    private float attacco;
    private float puntiVita;
    private int x;
    private int y;

    public Mostro(String nome, float attacco, float puntiVita, int x, int y) {
        this.attacco = attacco;
        this.puntiVita = puntiVita;
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    //Ritorna true se il mostro ha punti vita
    public boolean isVivo(){
        return puntiVita > 0;
    }

    //Un mostro attacca un'altro mostro, la sua vita viene decrementata
    public void attacca(Mostro vicino){
        vicino.setPuntiVita(vicino.getPuntiVita() + this.attacco);
    }

    //Ritorna true se il mostro è vicino, cioè se le loro x o y sono adiacenti
    // 0 0 0 0
    // 0 0 a 0
    // 0 a X a
    // 0 0 a 0
    //Se il mostro è X allora il mostro a si trova vicino, la differenza del valore assoluto
    //delle x e y deve essere 1
    public boolean isVicino(Mostro altroMostro){
        return Math.abs(altroMostro.getX()- x) + Math.abs(altroMostro.getY()-y) ==1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(float puntiVita) {
        this.puntiVita = puntiVita;
    }

    public float getAttacco() {
        return attacco;
    }

    public void setAttacco(float attacco) {
        this.attacco = attacco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
