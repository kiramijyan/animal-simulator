package app.utils;

import static app.data.Values.GRID_X;
import static app.data.Values.GRID_Y;

import java.util.LinkedList;

import app.animal.Animal;
import app.data.DB;
import app.matrix.Grid;

public class Printer {
	
	/**
	 * Print matrix By Type in grids and coordinates
	 * @throws InterruptedException
	 */
	public static void printMatrix() throws InterruptedException {
		for(int y = 0; y < GRID_Y; y++) {
			for(int x = 0; x < GRID_X; x++) {
				//Thread.sleep(70);
				if(DB.gridMatrix[x][y].getAnimalList().isEmpty()) {
					
					System.out.print("|  °  |");
				} else if(DB.gridMatrix[x][y].getAnimalList().size() == 1){
					//Thread.sleep(70);
					String id = String.format("%02d",DB.gridMatrix[x][y].getAnimalList().get(0).getID_Animal());
					System.out.print("|" + DB.gridMatrix[x][y].getAnimalList().get(0).getType() + "  " + id +"|");
				} else {
					//Thread.sleep(70);
					System.out.print("|  " + DB.gridMatrix[x][y].getAnimalList().size() + "  |");
				}
			}
			Thread.sleep(70);
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printLocalListAnimals(LinkedList<Animal> localList)  throws InterruptedException {
		for(int i = 0; i < localList.size(); i++) {
			Thread.sleep(300);
		}
		System.out.println();
	}
	public static void printExistingAnimals() {
		for(int i = 0; i < DB.animalList.size(); i++) {
			System.out.println(DB.animalList.get(i).info());
		}
	}
	
	public static void printAnimalListInfo(Grid grid) {
		System.out.println("" + grid.getAnimalList().size() + " animals in list, " + grid.getAnimalList().toString());
		
	}
	
	public static void printLine() {

		for(int i = 0; i < GRID_X; i++) {
			System.out.print("-------");
		}
		System.out.println();
	}
}
