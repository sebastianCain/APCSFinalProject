import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class TileImage extends Image {
    private int _x;
    private int _y;
    
    public TileImage(String i, int x, int y) {
        super(i);
        setSize(45,45);
        setLocation(x, y);
        _x = x;
        _y = y;
    }
    
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) { // If left click
            // This accesses the tiles matrix of the app, selects the tile for this image, and calls its fliptile function
            MinesweeperApp._tiles[_x/50][_y/50].flipTile();
        } else if (e.getButton() == 3) {
            // Same here but for flagging
            MinesweeperApp._tiles[_x/50][_y/50].flagTile();
        }
    }
}