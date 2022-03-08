package app.utils;

import app.data.DB;
import app.matrix.Coordinates;

import static app.data.Values.SPEED_ZOMBIE;
import static app.data.Values.TYPE_PIGEON;
import static app.data.Values.TYPE_RAT;
import static app.data.Values.TYPE_ZOMBIE;

import java.util.LinkedList;
import java.util.Random;

import app.animal.*;

public class FightTools {

	/**
	 * Loops throw all Grids and finds the grids where fight must be done
	 * @throws InterruptedException
	 */
	public static void checkGridsForFight() throws InterruptedException {
		for(int i = 0; i < DB.gridList.size(); i++) {
			if(DB.gridList.get(i).getAnimalList().size() > 1) {
				Printer.printAnimalListInfo(DB.gridList.get(i));
				Thread.sleep(300);
				fightInGrid(DB.gridList.get(i).getAnimalList());
				Thread.sleep(200);
			}
		}
	}

	/**
	 * Repeats fight infinitely until there will be only one or one type of animal in local list
	 * @param localList
	 * @throws InterruptedException
	 */
	public static void fightInGrid(LinkedList<Animal> localList) throws InterruptedException {
		while(isListFighting(localList)) {
			for(int i = 0; i < localList.size() - 1; i++) {
				if(localList.get(i).getType().equals(TYPE_ZOMBIE) && !localList.get(i + 1).getType().equals(TYPE_ZOMBIE)) {
					makeZombie(localList.get(i + 1), localList);
				} else if(localList.get(i + 1).getType().equals(TYPE_ZOMBIE) && !localList.get(i).getType().equals(TYPE_ZOMBIE)) {
					makeZombie(localList.get(i), localList);
				} else if (!localList.get(i).getType().equals(localList.get(i + 1).getType())){
					fightTwoAnimals(localList.get(i), localList.get(i + 1), localList);
				}			
				Thread.sleep(500);
			}
			fightInGrid(localList);
		}
	}
	
	/**
	 * Takes two animals and local list(List in grid)
	 * checks their type and organizes the fight 
	 * @param a
	 * @param b
	 * @param localList
	 * @throws InterruptedException
	 */
	public static void fightTwoAnimals(Animal a, Animal b, LinkedList<Animal> localList) throws InterruptedException {
		Random rand = new Random();
		int number = rand.nextInt((100 - 1) + 1) + 1; // 1 and 2		
		System.out.println("Figh        " + a.getID_Animal() + " " + a.getType() + " vs " + b.getID_Animal() + " " + b.getType());
		System.out.println("Coordinates " + a.getCoordinates());
		if(number % 2 == 0) {
			System.out.print("Winner " + b.info() + ". ");
			System.out.println("Dead " + a.info());
			Thread.sleep(500);
			DB.animalList.remove(a);
			localList.remove(a);
			a.setCoordinates(new Coordinates(-1, -1));
			a.setLive(false);
		} else {
			System.out.print("Winner " + a.info() + ". ");
			System.out.println("Dead " + b.info());
			Thread.sleep(500);
			DB.animalList.remove(b);
			localList.remove(b);
			b.setCoordinates(new Coordinates(-1, -1));
			b.setLive(false);
		}	
		System.out.println();
	}
	
	/**
	 * Takes an argument a list, checks if all the element in list are the same type
	 * If yes returns true no returns false
	 * @param localList
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean isListFighting(LinkedList<Animal> localList) throws InterruptedException {	
		if(localList.size() < 2) {
			return false;
		}
		if(localList.stream().allMatch(n -> n.getType().equals(TYPE_RAT))
			|| localList.stream().allMatch(n -> n.getType().equals(TYPE_PIGEON))
			|| localList.stream().allMatch(n -> n.getType().equals(TYPE_ZOMBIE))) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Takes an animal and localList in grid
	 * Deletes the animal and creates the zombie
	 * Puts the new created zombie in the place of animal
	 * @param animal
	 * @param localList
	 */
	public static void makeZombie(Animal animal, LinkedList<Animal> localList) {
		System.err.println(animal.info() + " Become zombie:");
		int id = animal.getID_Animal();
		Zombie zombie = new Zombie(TYPE_ZOMBIE, SPEED_ZOMBIE);
		zombie.setID_Animal(id);
		for(int i = 0; i < DB.animalList.size(); i++) {
			if(DB.animalList.get(i).equals(animal)) {
				DB.animalList.set(i, zombie);
			}
		}
		for(int i = 0; i < localList.size(); i++) {
			if(localList.get(i).equals(animal)) {
				localList.set(i, zombie);
			}
		}	
	}
}
