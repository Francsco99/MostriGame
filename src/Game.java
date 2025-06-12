import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int turni;
    private Board board;
    private List<Mostro> mostri;

    public Game(int turni, Board board, List<Mostro> mostri){
        this.turni = turni;
        this.board = board;
        this.mostri = new ArrayList<Mostro>();
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
        this.mostri.add(new Mostro("Nebbia",20, 5, x1,y1));
        this.mostri.add(new Mostro("Granca",25, 3, x1,y1));
    }



}
