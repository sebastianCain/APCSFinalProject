import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class TileImage extends Image {
    private int _x;
    private int _y;
    
    public TileImage(String i, int x, int y) {
        super(i);
        setSize(MinesweeperApp._sl,MinesweeperApp._sl);
        setLocation(x, y);
        _x = x;
        _y = y;
    }
    
	public void mousePressed(MouseEvent e) {
		MinesweeperApp._tiles[_x/MinesweeperApp._sl][_y/MinesweeperApp._sl].invTile();
	}

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) { // If left click
            // This accesses the tiles matrix of the app, selects the tile for this image, and calls its fliptile function
            MinesweeperApp._tiles[_x/MinesweeperApp._sl][_y/MinesweeperApp._sl].flipTile();
        } else if (e.getButton() == 3) {
            // Same here but for flagging
            MinesweeperApp._tiles[_x/MinesweeperApp._sl][_y/MinesweeperApp._sl].flagTile();
        }
    }
}
