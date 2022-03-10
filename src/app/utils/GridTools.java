package app.utils;

import app.animal.Animal;
import app.data.DB;

public class GridTools {
	
	
	/**
	 * Loops throw all animal list if animal coordinates are the same as the grid coordinates
	 * puts animal in the list inside of grid
	 */
	public static void putAnimalsToGrids() {
		for(int i = 0; i < DB.gridList.size(); i++) {
			for(int j = 0; j < DB.animalList.size(); j++) {				
				if( DB.gridList.get(i).getCoordinates().equals(DB.animalList.get(j).getCoordinates()) ) {
					 DB.gridList.get(i).getAnimalList().add(DB.animalList.get(j) );
				}
			}
		}
	}
	
	/**
	 * Loops throw all animals and changes their coordinates to simulate movement according animal speed
	 * 
	 * @throws InterruptedException
	 */
	public static void moveAnimal() throws InterruptedException {
		for(int i = 0; i < DB.animalList.size(); i++) {
			int randomDirection = (int) (Math.random() * 4);
			removeAnimalFromGridList(DB.animalList.get(i));
			MoveTools.move(DB.animalList.get(i), randomDirection);
		}
	}
	
	/**
	 * Loops throw the lists inside the grids removes animals from the list inside the grid 
	 * @param animal
	 */
	public static void removeAnimalFromGridList(Animal animal) {
		for(int x = 0; x < DB.gridMatrix.length; x++) {
			for(int y = 0; y < DB.gridMatrix[x].length; y++)
			if(DB.gridMatrix[x][y].getAnimalList().contains(animal)) {
				DB.gridMatrix[x][y].getAnimalList().remove(animal);
			}
		}
	}
}
