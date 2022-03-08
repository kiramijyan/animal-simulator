package app.utils;

import app.data.DB;

public class Runner {
	
	/**
	 * Starts the program, move animals, ends the program
	 * @throws InterruptedException
	 */
	public static void run() throws InterruptedException {
		
		Initializer.start();
		Printer.printExistingAnimals();
		System.out.println("START");
		Printer.printMatrix();
		Thread.sleep(500);
		
		int count = 0;
		while(FightTools.isListFighting(DB.animalList)) {

			System.out.println("Count " + count++);
			Thread.sleep(300);
			GridTools.moveAnimal();
			GridTools.putAnimalsToGrids();
			Printer.printMatrix();
			FightTools.checkGridsForFight();
			Printer.printLine();
		}	
		
		Thread.sleep(300);
		System.out.println("END");
		System.out.println("Number of movements " + count);
		Printer.printMatrix();
		Printer.printExistingAnimals();
	}

}
