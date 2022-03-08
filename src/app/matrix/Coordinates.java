package app.matrix;

public class Coordinates {
	
	private int x;
	private int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean equals (Coordinates obj) {
		if(this.x == obj.getX() && this.y == obj.getY()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "X:"+this.x + " Y:" + this.y;
	}
}
