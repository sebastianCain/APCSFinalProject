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
        
		int sideLength = 45;
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
        
        int sideLength = 45;
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
    
    // This function "flips" tiles by changing the image property.
    public void flipTile() {
        if (!_isFaceUp) {
            if (_isMine) {
                _image.hide();
                _image = new TileImage("./images/mine.png", getX(), getY());
            } else {
                _image = new TileImage("./images/" + _adjacentMines + ".png", getX(), getY());
            }
            _isFaceUp = true;
        }
    }
    
    // Same for flagging, except you can toggle.
    public void flagTile() {
        if (!_isFlagged) {
            _image = new TileImage("./images/flag.png", getX(), getY());
            _isFlagged = true;
        } else {
            _image = new TileImage("./images/tile.png", getX(), getY());
            _isFlagged = false;
        }
    }
}
		
		
