/**
 * @author hovhannes.kiramijyan
 * Starts program 
 * DB initialization
 * Matrix creation
 * Animal Creation
 * Put animals in grids
 * Put grids in matrix
 * Assign default coordinates to grids and animals
 * Mix matrix to have random position for grids with animals in matrix
 */

package app.utils;

import app.animal.*;
import app.data.DB;
import app.matrix.Coordinates;
import app.matrix.Grid;

import static app.data.Values.*;

import java.util.Collections;

public class Initializer {
	
	
	/**
	 * Starts application initialization,
	 * Runs the methods to organize application for it's initial state
	 */
	public static void start() {
		createRandomAnimals();
		creatGrids();
		addAnimalsIntoGrids();
		mixGridsRandomly();
		addGridsToMatrix();
		updateAnimalCoordinates();
		updateGridCoordinates();
	}
	
	/**
	 * Creates N number of different type of animals
	 * Adds animals into the static list of type Animal, from 0 - N
	 */
	public static void createRandomAnimals(){
		for(int i = 0; i < TOTAL_ANIMALS; i++) {
			int radomNumber = (int) (Math.random() * 3);
			if(radomNumber == 0) { DB.animalList.add(new Pigeon(TYPE_PIGEON, SPEED_PIGEON)); }
			if(radomNumber == 1) { DB.animalList.add(new Rat(TYPE_RAT, SPEED_RAT)); }
			//if(radomNumber == 2) { DB.animalList.add(new Rat(TYPE_RAT, SPEED_RAT)); }
			if(radomNumber == 2) { DB.animalList.add(new Zombie(TYPE_ZOMBIE, SPEED_ZOMBIE)); }
		}
	}
	
	/**
	 * Updates Animals Coordinates according the grid matrix
	 */
	public static void updateAnimalCoordinates(){
		for(int y = 0; y < GRID_Y; y++) {
			for(int x = 0; x < GRID_X; x++) {
					final int X = x;
					final int Y = y;
					DB.gridMatrix[x][y]
						.getAnimalList()
						.stream()
						.forEach(n -> n.setCoordinates(new Coordinates(X, Y)));
			}
		}
	}
	
	/**
	 * Creates N (the number of elements in matrix) Grid Type Objects
	 * Add that Grids into static GridList
	 * The length of list is equal to the number of elements in matrix X * Y
	 */
	public static void creatGrids() {
		for(int i = 0; i < GRID_X * GRID_Y; i++) {
			DB.gridList.add(new Grid(0, 0));
		}
	}
	
	/**
	 * Adds Animals from static animal List into List of Grids
	 * Each Grid object has field Animal List, which will serve to keep animals in current grid  
	 * Some grids will not have animals
	 */
	public static void addAnimalsIntoGrids() {
		for(int i = 0; i < DB.animalList.size(); i++) {
			DB.gridList.get(i).addAnimalToList(DB.animalList.get(i));
		}
	}
	
	/**
	 * Mix list of grids randomly
	 */
	public static void mixGridsRandomly() {
		Collections.shuffle(DB.gridList);
	}
	
	/**
	 * Add Grids into matrix
	 */
	public static void addGridsToMatrix() {
		int index = 0;
		for(int y = 0; y < GRID_Y; y++) {
			for(int x = 0; x < GRID_X; x++) {
				DB.gridMatrix[x][y] = DB.gridList.get(index);
				index++;
			}
		}
	}	
	
	/**
	 * Update Grid coordinates by matrix X Y
	 */
	public static void updateGridCoordinates() {
		for(int y = 0; y < GRID_Y; y++) {
			for(int x = 0; x < GRID_X; x++) {
				DB.gridMatrix[x][y].setCoordinates(new Coordinates(x, y));
			}
		}
	}
}
