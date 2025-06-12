public class Board {
    private int dimensione;
    private String[][] griglia;

    public Board(int dimensione) {
        this.dimensione = dimensione;
        this.griglia = new String[dimensione][dimensione];
        costruisciGriglia();
    }

    //Metodo che usiamo solo per inizializzare la griglia con tutti "o" cioè celle vuote
    private void costruisciGriglia(){
        for(int i = 0; i < dimensione; i++){
            for(int j = 0; j < dimensione; j++){
                griglia[i][j] = "o";
            }
        }
    }

    public void stampaGriglia(){
        for(int i = 0; i < dimensione; i++){
            for(int j = 0; j < dimensione; j++){
                //Stampiamo una cella e uno spazio
                System.out.print(this.griglia[i][j] + " ");
            }
            //alla fine di ogni riga andiamo a capo
            System.out.println();
        }
    }
}
