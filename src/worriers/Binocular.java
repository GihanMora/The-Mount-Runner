package worriers;
import java.util.Arrays;

import MyGamePackage.Grid;
import MyGamePackage.MagicTree;
import MyGamePackage.MyGameSetup;

public class Binocular { 																								      // the binocular will always check near four locations whether there are trees..
	public synchronized void checkTrees(SuperWorrior worrier) { 															  // take parameter as super worrier type object
		int x = worrier.getLocation()[0];																					  //This method has synchronized because at once one super worrier can access this
		int y = worrier.getLocation()[1];
		int[] leftLocation = { x - 1, y }; 																					  // left location of worrier
		int[] rightLocation = { x + 1, y };																				      // right location of worrier
		int[] upLocation = { x, y + 1 }; 																					  // up location of worrier
		int[] downLocation = { x, y - 1 }; 																					  // down location of worrier
		
	if(x>0 && Grid.getGridPoint(x-1, y,0) instanceof MagicTree){
		binocularJob(worrier, leftLocation);}
	else if(x<10 && Grid.getGridPoint(x+1, y,0) instanceof MagicTree){
		binocularJob(worrier, rightLocation);}
	else if(y<10 && Grid.getGridPoint(x, y+1,0) instanceof MagicTree){
		binocularJob(worrier, upLocation);}
	else if(y>0 && Grid.getGridPoint(x, y-1,0) instanceof MagicTree){
		binocularJob(worrier, downLocation);}
	}
	private synchronized void binocularJob(SuperWorrior worrier, int[] watchingDirection) {
		System.out.println(worrier.getName() + " can see a tree through binocular at " + Arrays.toString(watchingDirection)); // displays that there is a tree in watching direction
		worrier.setLocation(watchingDirection);
		MyGameSetup.LandOFModor.setGridPoint(watchingDirection[0], watchingDirection[1], this);								  //update the grid
		System.out.println(worrier.getName() + " walking to " + watchingDirection[0] + " " + watchingDirection[1]);			  // worrier  moves to that tree
		
	
	}
}
