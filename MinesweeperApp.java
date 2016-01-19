import wheels.users.*;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperApp extends Frame {

    private static boolean[][] _board;
    public static Tile[][] _tiles;
    
    public MinesweeperApp() {
    	super();
        
        // The board is defined as a matrix of 14x10, with booleans defining if the tile at that position is a mine or not.
        _board = new boolean[14][10];
        _tiles = new Tile[14][10];
        
        createBoard();
    }
    
    public static void createBoard() {
        
        // This nested loop creates the board with mines in random places, with the percent chance of a tile being a mine at 20%
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                double r = Math.random();
                boolean isMine = (r < .2);
                _board[i][j] = isMine;
            }
        }
        
        // Now, with the boolean grid laid out, tiles are instantiated with the proper # of adjacent mines.
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 10; j++) {
                // The tiles get instantiated and added to the tile matrix
                if (getBV(i,j)) {
                    Tile newTile = new Tile(i*50, j*50);
                    _tiles[i][j] = newTile;
                } else {
                    Tile newTile = new Tile(i*50, j*50, getAdj(i,j));
                    _tiles[i][j] = newTile;
                }
            }
        }
    }
    
    
    public static boolean getBV(int x, int y) {
        return _board[x][y];
    }
    
    // This function returns the number of adjacent mines for any given tile.
    public static int getAdj(int x, int y) {
        int total = 0;
        
        // These loops get the surrounding values, accounting for edge cases.
        for (int i = Math.max(x-1,0); i <= Math.min(x+1,13); i++) {
            for (int j = Math.max(y-1,0); j <= Math.min(y+1,9); j++) {
                if (getBV(i,j))
                    total += 1;
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        MinesweeperApp app = new MinesweeperApp();
    }
    
}
