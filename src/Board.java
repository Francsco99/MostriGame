import java.util.List;

public class Board {
    private int righe;
    private int colonne;
    private String[][] griglia;

    public Board(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.griglia = new String[righe][colonne];
        costruisciGriglia();
    }

    //Metodo che usiamo solo per inizializzare la griglia con tutti "o" cioè celle vuote
    private void costruisciGriglia(){
        for(int i = 0; i < righe; i++){
            for(int j = 0; j < colonne; j++){
                griglia[i][j] = "o";
            }
        }
    }

    //Metodo per aggiornare la griglia
    public void aggiornaGriglia(List<Mostro> mostri){
        //Per prima cosa rimuoviamo tutti i vecchi mostri
        costruisciGriglia();

        for(Mostro m : mostri){
            int x = m.getX();
            int y = m.getY();
        //I mostri possono essere in due posizioni diverse o nella stessa
            //Se la cella (x,y) NON ha una "o" allora già c'è un mostro
            if(!this.griglia[x][y].equals("o")){
                this.griglia[x][y] = "X"; //Se sono nella stessa posizione ci mettiamo X
            }
            else{
                this.griglia[x][y] = m.getNome().substring(0,1).toUpperCase(); //Ci mettiamo la prima lettera del nome in maiuscolo
            }
        }
    }
    //Metodo per stampare la griglia
    public void stampaGriglia(){
        for(int i = 0; i < righe; i++){
            for(int j = 0; j < colonne; j++){
                //Stampiamo una cella e uno spazio
                System.out.print(this.griglia[i][j] + " ");
            }
            //alla fine di ogni riga andiamo a capo
            System.out.println();
        }
    }

    public int getRighe() {
        return righe;
    }

    public void setRighe(int righe) {
        this.righe = righe;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String[][] getGriglia() {
        return griglia;
    }

    public void setGriglia(String[][] griglia) {
        this.griglia = griglia;
    }
}
