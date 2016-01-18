import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Tile extends Rectangle {
	
	private boolean _faceUp;
	private boolean _isMine;
	//private boolean _sideLength;
	
	public Tile(int x, int y, int isMine) {
		super(x,y);
		int sideLength = 45;
		setSize(sideLength,sideLength);
		setLocation(x,y);
		setColor(Color.BLACK);
        if (isMine == 1) _isMine = true;
        else _isMine = false;
	}
	//public void getSideLength() { return _sideLength; }
	public void mouseReleased(MouseEvent e) {
		if (_isMine) setColor(Color.RED);
		else setColor(Color.GRAY);
	}
}
		
		
