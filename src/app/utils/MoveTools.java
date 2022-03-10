package app.utils;

import static app.data.Values.*;

import app.animal.Animal;

public class MoveTools {

	public static boolean flagUpDown = true;

	public static boolean flagLeftRight = true;
	
	public static void move(Animal animal, int randomDirection) {       
		
		if(animal.isLive()) {
			int x = 0;  
	        while(x < animal.getSpeed()) {
	        	if(randomDirection == 0) { moveLeft(animal); }
	            if(randomDirection == 1) { moveRigth(animal); }
	            if(randomDirection == 2) { moveDown(animal); }
	            if(randomDirection == 3) { moveUp(animal); }
				x++;
			}
		}
	}
	
	/**
	 * Move algorithm
	 * @param animal
	 */
	public static void moveDown(Animal animal) {
		int aY = animal.getCoordinates().getY(); 
		// System.out.print("Down :");
		if (aY + 1 < GRID_Y && flagUpDown == true) {
			animal.getCoordinates().setY(++aY);
			animal.setDirection("Down");
		} else {
			flagUpDown = false;
			moveUp(animal);
		}
	}
	
	public static void moveUp(Animal animal) {
		int aY = animal.getCoordinates().getY(); 
		if(aY - 1 >= 0 && !flagUpDown) {
			// System.out.print("Up:  ");
			--aY;
			animal.getCoordinates().setY(aY);
			animal.setDirection("Up");
		} else {
			flagUpDown = true;
			moveDown(animal);
		}
	}
	
	public static void moveRigth(Animal animal) {
		int aX = animal.getCoordinates().getX(); 
		if (aX + 1 < GRID_X && flagLeftRight == true) {
			// System.out.print("Right:");
			++aX;
			animal.getCoordinates().setX(aX);
			animal.setDirection("Rigth");
			// System.err.println("1 flag");
		} else {
			// System.err.println("2 flag");
			flagLeftRight = false;
			moveLeft(animal);
		}
	}
	
	public static void moveLeft(Animal animal) {
		int aX = animal.getCoordinates().getX(); 
		if(aX - 1 >= 0 && !flagLeftRight) {
			// System.out.print("Left:");
			--aX;
			animal.getCoordinates().setX(aX);
			animal.setDirection("Left");
		} else {
			flagLeftRight = true;
			moveRigth(animal);
		}
	}
}
