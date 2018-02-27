package MyGamePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import monsters.InnocentMonster;
import monsters.Monster;
import monsters.NonInnocentMonster;
import worriers.NormalWorrior;
import worriers.SuperWorrior;
import worriers.Worrior;

public class MyGameSetup { 																			// this class is to set up the game by creating object lists and initializing objects
	private static int[][] monsterAndTreelocations = Location.makerandomlist();						// make random list of tree and monster locations
	private static int[][] monstersLocations = new int[5][2]; 										// list for  monster locations
	public static int[][] treeLocations = new int[5][2]; 											// list for tree locations
	static int[][] worrierloc = Location.setWorriorLocations();
	private static String[] monsternames = { "evil", "devil", "adam", "graze", "bonny" }; 			// name list of monsters and use  encapsulation
	private static String[] worriornames = { "David", "Arther", "Simon", "Leonardo" }; 				// name list for  worriers and use encapsulation
	private static String[] treenames = { "Mango", "Banana", "Avacado", "Orange", "Dragonfruit" };  // name list for trees  and use encapsulation
	private static Monster[] mostersList = new Monster[5]; 											// create a list of monster reference objects..uses Polymorphism
	public static Worrior[] worriorsList = new Worrior[4]; 											// create a list of  worrier reference objects..uses Polymorphism
	private static MagicTree[] treeList = new MagicTree[5]; 										// create a list of magic tree objects
	public static Mount MountDoom = new Mount(); 													// create mount object for MOUNT DOOM
	public static Grid LandOFModor = new Grid(); 													// create the Land of Modor(The grid)

	private static void makeMosterAndTreeLocationLists() { 											// a method for declare tree and monster location lists
		for (int p = 0; p < 10; p++) {
			if (p < 5) {
				monstersLocations[p] = monsterAndTreelocations[p];
			} else {
				treeLocations[p - 5] = monsterAndTreelocations[p];
			}
		}
	}

	private static void objectDeclare() { 															// method for declare all the objects
		for (int i = 0; i < 4; i++) { 																// declaring worriers
			if (i < 2) {
				worriorsList[i] = new NormalWorrior(worriornames[i], Location.worriorlocations[i]);
			} else {
				worriorsList[i] = new SuperWorrior(worriornames[i], Location.worriorlocations[i]);
			}
		}
		for (int j = 0; j < 5; j++) { 																// declaring monsters
			if (j < 3) {
				mostersList[j] = new InnocentMonster(monsternames[j], monsterAndTreelocations[j]);
			} else {
				mostersList[j] = new NonInnocentMonster(monsternames[j], monsterAndTreelocations[j]);
			}
		}
		for (int k = 0; k < 5; k++) { 																// declaring trees
			treeList[k] = new MagicTree(treenames[k], monsterAndTreelocations[k + 5]);
		}
	}

	public static void main(String[] args) { 														// main method of the package
		makeMosterAndTreeLocationLists();
		objectDeclare();
		LandOFModor.setGrid();
		System.out.println(" Welcome!! ");															//greetings for starting the game
		System.out.println("..*.Game Started.*..");
		System.out.println("Trees are located at..");												//display tree locations
		for (int[] i : treeLocations) {
			System.out.print(" " + Arrays.toString(i));
		}
		System.out.println();
		System.out.println("Monsters are staying at..");											//display monster locations
		for (int[] i : monstersLocations) {
			System.out.print(" " + Arrays.toString(i));
		}
		System.out.println();
		worriorsList[0].start(); 																	// worriers start walking simultaneously 
		worriorsList[1].start(); 																	// worriers start walking simultaneously
		worriorsList[2].start(); 																	// worriers start walking simultaneously
		worriorsList[3].start(); 																	// worriers start walking simultaneously
		
	}

	public static int[][] getmonLoclist() { 														// getter for monster location list
		return monstersLocations;
	}

	public static MagicTree[] gettreelist() { 														// getter for tree list
		return treeList;
	}

	public static String[] getmonstnamelist() { 													// getter for monster name list
		return monsternames;
	}

	public static Monster[] getmonstlist() { 														// getter for monster list
		return mostersList;
	}

}
