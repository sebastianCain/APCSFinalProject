import wheels.users.*;

public class MinesweeperApp extends Frame {

    public MinesweeperApp() {
    	super();
        
        for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				double r = Math.random();
				boolean isMine = false;
				if (r < .3) isMine = true;
				Tile newTile = new Tile(i*50, j*50, isMine);
			}
		}

    }
    
    public static void main(String[] args) {
        MinesweeperApp app = new MinesweeperApp();
    }
}
