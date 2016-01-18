import wheels.users.*;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperApp extends Frame {

    private ArrayList<ArrayList<Integer>> _board;
    
    public MinesweeperApp() {
    	super();
        
        _board = ArrayList<ArrayList<Integer>>(10);
    }
    
    public static void createBoard() {
        
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                double r = Math.random();
                boolean isMine = false;
                if (r < .3) {
                    isMine = true;
                } else {
                    Tile newTile = new Tile(i*50, j*50);
                }
            }
        }
    }
    
    public static void createTiles() {
        
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                Tile newTile = new Tile(i*50, j*50, _board.get(i).get(j));
            }
        }
    }
    
    public static void main(String[] args) {
        MinesweeperApp app = new MinesweeperApp();
    }
}
