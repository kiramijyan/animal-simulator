package app.animal;

import java.util.Objects;

import app.matrix.*;

public abstract class Animal {
	
	private static int counter;
	private int ID_Animal;
	private int speed; 
	private int points;
	private String type;
	protected boolean isLive = true;
	private Coordinates coordinates = new Coordinates(0, 0);
	private String direction = "";
	
	public Animal(String type, int speed) {
		this.speed = speed;
		this.type = type;
		counter++;
		this.ID_Animal = counter;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getID_Animal() {
		return this.ID_Animal;
	}

	public void setID_Animal(int iD_Animal) {
		this.ID_Animal = iD_Animal;
	}

	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ID_Animal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return ID_Animal == other.ID_Animal;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public boolean equals(Animal a) {
		return this.ID_Animal == a.ID_Animal;
	}
	
	public String info() {
		return "ID:" + this.ID_Animal + ", Type: " + this.type +  " , " + this.coordinates;
	}
	
	@Override
	public String toString() {
		return "ID " + this.ID_Animal  + ", type " + this.type + ", " + this.coordinates.toString() + ": "; 
	}
}
