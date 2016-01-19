import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Tile extends Rectangle {
	
	private boolean _isFaceUp;
    private boolean _isFlagged;
	private boolean _isMine;
    private int _adjacentMines;
    private int _x;
    private int _y;
    private TileImage _image;
	
    //Constructor for mines, no adjacentMines value needed
    
	public Tile(int x, int y) {
		super(x,y);
        
		int sideLength = MinesweeperApp._sl;
		setSize(sideLength,sideLength);
		setLocation(x,y);
        setColor(Color.white);
        
        _x = x;
        _y = y;
        _isMine = true;
        _isFaceUp = false;
        
        _image = new TileImage("./images/tile.png", _x, _y);
        
    }
    
    // Constructor for other tiles
    
    public Tile(int x, int y, int adjacentMines) {
        super(x,y);
        
        int sideLength = MinesweeperApp._sl;
        setSize(sideLength,sideLength);
        setLocation(x,y);
        setColor(Color.white);
        
        _x = x;
        _y = y;
        _isMine = false;
        _isFaceUp = false;
        _adjacentMines = adjacentMines;
        
        _image = new TileImage("./images/tile.png", _x, _y);
    }
    
    public int getX() {
        return _x;
    }
    
    public int getY() {
        return _y;
    }
    
    public int getAdjMines() {
        return _adjacentMines;
    }
	
	public void setTileImage(String s) {
		_image = null;
		_image = new TileImage(s, getX(), getY());
    }
    // This function "flips" tiles by changing the image property.
    public void flipTile() {
        if (!_isFaceUp) {
            if (_isMine) {
                _image.hide();
                setTileImage("./images/mine.png");
            } else {
                setTileImage("./images/" + _adjacentMines + ".png");
            }
            _isFaceUp = true;
        }
    }
    
    // Same for flagging, except you can toggle.
    public void flagTile() {
        if (!_isFlagged) {
            setTileImage("./images/flag.png");
            _isFlagged = true;
        } else {
            setTileImage("./images/tile.png");
            _isFlagged = false;
        }
    }
	
	public void invTile() {
		if (!_isFaceUp)	setTileImage("./images/tile_inv.png");
	}
}
		
		
