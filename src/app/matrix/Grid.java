package app.matrix;

import java.util.*;

import app.animal.*;

public class Grid {
	
	private LinkedList<Animal> animalList = new LinkedList<Animal>();
	private Coordinates coordinates = new Coordinates(0, 0);
	
	public Grid(int x, int y) {
		super();
		this.coordinates.setX(x);
		this.coordinates.setY(y);
	}
	
	public void addAnimalToList(Animal animal) {
		this.animalList.add(animal);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public LinkedList<Animal> getAnimalList() {
		return animalList;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
