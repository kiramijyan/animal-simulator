package app.data;

import static app.data.Values.*;

import java.util.*;

import app.animal.*;
import app.matrix.Grid;

public class DB {
	
	/**
	 * List of the objects type Grid
	 */
	public static LinkedList<Grid> gridList = new LinkedList<>();
	
	/**
	 * Matrix of type Grid
	 */
	public static Grid[][] gridMatrix = new Grid[GRID_X][GRID_Y];
	
	/**
	 * List of all existing animals
	 */
	public static LinkedList<Animal> animalList = new LinkedList<>();
}
