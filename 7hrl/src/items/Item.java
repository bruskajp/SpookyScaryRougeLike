package items;

public abstract class Item {
	
	int xCoordinate;
	int yCoordinate;
	Character displayCharacter;
	
	public Item(){
		this.initialize();
	}
	
	private void initialize() {
		xCoordinate = -1;
		yCoordinate = -1;
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Character getDisplayCharacter() {
		return displayCharacter;
	}
	
}
