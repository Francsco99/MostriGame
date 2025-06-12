import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int turni;
    private Board board;
    private List<Mostro> mostri;

    public Game(int turni, int righe, int colonne){
        this.turni = turni;
        this.board = new Board(righe,colonne);
        this.mostri = new ArrayList<Mostro>();
        generaMostri();
    }

    private void generaMostri(){
        Random rand = new Random();

        //Primo mostro
        int x1 = rand.nextInt(board.getRighe());
        int y1 = rand.nextInt(board.getColonne());

        //Secondo mostro, mettiamo in una posizione diversa con un do-while
        int x2;
        int y2;
        do {
            x2 = rand.nextInt(board.getRighe());
            y2 = rand.nextInt(board.getColonne());
        } while (x2==x1 && y2==y1);

        //Per ora aggiungiamo due mostri in maniera statica
        this.mostri.add(new Mostro("Nebbia",5, 20, x1,y1));
        this.mostri.add(new Mostro("Granca",4, 25, x2,y2));
    }

    public void startGame(){
        for(int i = 0; i < this.turni; i++){
            System.out.println("Turno "+i+": ");

            //Muoviamo i mostri
            for(Mostro m: this.mostri){
                if(m.isVivo()){
                    m.muovi(this.board.getRighe(),this.board.getColonne());
                }
            }

            //Combattimento
            Mostro m1 = this.mostri.get(0);
            Mostro m2 = this.mostri.get(1);

            if(m1.isVivo() && m2.isVivo() && m1.isVicino(m2)){
                m1.attacca(m2);
                if (m2.isVivo()){
                    m2.attacca(m1);
                }
            }

            //Aggiornamento posizioni
            this.board.aggiornaGriglia(mostri);
            board.stampaGriglia();

            //Stampa info mostri
            for (Mostro m: this.mostri){
                m.descrizione();
            }
            System.out.println("-------------------");

            if (!m1.isVivo() || !m2.isVivo()) {
                System.out.println("Battaglia conclusa!");
                break;
            }

        }

        // Vincitore
        for (Mostro m : mostri) {
            if (m.isVivo()) {
                System.out.println(m.getNome() + " ha vinto!");
            }
        }

    }
}
