package MyGamePackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Location { 																		        // this class handles all the location duties
	static ArrayList<ArrayList<Integer>> allLocations = new ArrayList<ArrayList<Integer>>(); 			// this array hold all the locations
	public static int[] mount = { 5, 5 }; 																		// declare mount doom`s location
	static int[][] randomlocations = new int[10][2]; 													// random locations list for trees and monsters
	static int[][] worriorlocations = new int[4][2]; 													// the locations for worriers

	public static int[][] makerandomlist() { 															// adding random locations to the random list where monsters and worriers locations are contained
		for (int count = 0; count < 10; count++) {
			int[] templocation = setLocations(); 														// calling set location method
			randomlocations[count] = templocation;
		}
		return randomlocations;
	}

	public static int[] setLocations() { 																// method to set random locations to  trees monsters that haven`t  previously used
		boolean isUsed = true;
		ArrayList<Integer> newLocation = new ArrayList<Integer>(2);
		ArrayList<Integer> mountdoom = new ArrayList<Integer>(2); 										// create mount doom as array list
		mountdoom.add(5); 																				// declare mount doom
		mountdoom.add(5); 																				// declare mount doom
		while (isUsed == true) { 																		// make sure that used locations are not using again
			isUsed = false;
			newLocation.clear(); 																		// clear the previous coordinates of new location
			Random r = new Random();
			newLocation.add(r.nextInt(10)); 															// add random number to x coordinate
			newLocation.add(r.nextInt(10)); 															// add random number to y coordinate
			if (newLocation.equals(mountdoom)) {
				isUsed = true;
			} 																							// check generated location is mount doom`s location
			for (int i = 0; i < allLocations.size(); i++) { 											// Check whether a used location
				if (allLocations.get(i).equals(newLocation)) { 											// check it is already used
					isUsed = true;
					break;
				}
			}
		}
		allLocations.add(newLocation); 																	// after produced not used location add it to array list locations
		int[] outarry = new int[2]; 																	// convert the array list to array as requires a array
		outarry[0] = newLocation.get(0); 																// convert the array list to array as requires a array
		outarry[1] = newLocation.get(1); 																// convert the array list to array as requires a array
		return outarry;
	}

	public static int[][] setWorriorLocations() {
		Random randomLocation = new Random();
		for (int i = 0; i < 4; i++) {
			int[] subloc = new int[2];
			int randomCase=randomLocation.nextInt(4);
			switch(randomCase){
			case 0 :
				subloc[0] = 0;
				subloc[1] = randomLocation.nextInt(11);                                                 // worrier will locate at left border
				break;
			case 1 :
				subloc[0] = randomLocation.nextInt(11);													// worrier will locate at Bottom border
				subloc[1] = 0;
				break;
			case 2 : 
				subloc[0] = randomLocation.nextInt(11);													// worrier will locate at Right border
				subloc[1] = 10;
				break;
			case 3 : 
				subloc[0] = 10;
				subloc[1] = randomLocation.nextInt(11);													// worrier will locate at up border
				break;
			}
			
			worriorlocations[i] = subloc;
		}
		return worriorlocations;

	}

}
