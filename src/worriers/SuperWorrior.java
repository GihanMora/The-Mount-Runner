package worriers;
import java.util.Arrays;
import java.util.Random;

import MyGamePackage.Grid;
import MyGamePackage.Location;
import MyGamePackage.MagicTree;
import MyGamePackage.Mount;
import MyGamePackage.MyGameSetup;
import monsters.InnocentMonster;
import monsters.Monster;
import monsters.NonInnocentMonster;

public class SuperWorrior extends Worrior { 															// using inheritance of worrier
	Binocular binocular = new Binocular(); 																// creates a binocular object for each super worrier
	public SuperWorrior(String name, int[] location) { 													// constructor
		super(name, location);
	}
public void walk() { 																					// method of walking
		try {
			Random r = new Random();
			int x = this.getLocation()[0];
			int y = this.getLocation()[1];																// x and y coordinates of the location
			System.out.println(this.getName()+"Started the battel of running "+x+" "+y);				//displaying that this worrier has started the battele
			while (mobility && !hassomeonewon) { 														// check whether mobility true and has someone won already
				
				synchronized(MyGameSetup.LandOFModor.getCell(x, y)){									//synchronized each step and uses lock as the current cell
					//System.out.println(t.getName()+"took"+x+" "+y);
					//System.out.println();
					int[] currentLoc = { x, y };
					int direction = r.nextInt(2);
					if (!this.getImmotility()) {														//check four near cells static positions for 
						binocular.checkTrees(this);														//trees by binocular
					} 
					if(MyGameSetup.LandOFModor.getGridPoint(this.getLocation()[0], this.getLocation()[1],0) instanceof MagicTree){
						this.eatFruit();																//if static position of current cell has a tre
						x=this.getLocation()[0];
						y=this.getLocation()[1];}
					
					if(MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof InnocentMonster){
					
					((InnocentMonster) MyGameSetup.LandOFModor.getGridPoint(x, y,0)).stealStick(this);}
				if(MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof NonInnocentMonster){			//if static position of current cell has a innocentMonster
					((NonInnocentMonster) MyGameSetup.LandOFModor.getGridPoint(x, y,0)).kill(this);}	//if static position of current cell has a non innocent monster
				if (MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof Mount){ 					//if static position of current cell has mount doom
					synchronized(MyGameSetup.MountDoom){
					MyGameSetup.MountDoom.notifyAllWorriors();		
					Thread.sleep(800);
					System.out.println(getName() + " Climbed the mountain and won!!!"); 				// display that worrier climbed the mountain
					System.out.println("<<<<<Game Finished!!!>>>>>");
					}
				}
				MyGameSetup.LandOFModor.clearGridPoint(x, y, 1);										//clear the dynamic position of previous cell
				if (x <= 5 && y <= 5) { 																// if worrier is in left down side of the grid step by step 
					if (direction == 0) {																//his x coordinate increment and y coordinate increment
						x += 1;
					} else {
						y += 1;
					}
				} else if (x <= 5 & y >= 5) { 															// if worrier is in right down side of the grid step by step his
					if (direction == 0) {																// x coordinate increment and y coordinate decrement
						x += 1;
					} else {
						y -= 1;
					}
				} else if (x >= 5 && y >= 5) { 															// if worrier is in right up side of the grid step by step his
					if (direction == 0) {																// x coordinate decrement and y coordinate decrement
						x -= 1;
					} else {
						y -= 1;
					}
				} else if (x >= 5 && y <= 5) { 															// if worrier is in left up side of the grid step by step his
					if (direction == 0) {																// x coordinate decrement and y coordinate increment
						x -= 1;
					} else {
						y += 1;
					}
				}
				if( MyGameSetup.LandOFModor.getGridPoint(x, y,1) instanceof Worrior){	
					x = currentLoc[0]; 																	// if that so this worrier remains previous x coordinate
					y = currentLoc[1];}
					int[] newlocation={x,y};
					this.setLocation(newlocation);
					MyGameSetup.LandOFModor.setGridPoint(x, y, this);	
					
					if( mobility && !hassomeonewon){
						System.out.println(getName() + " walking to " + x + " " + y); }					// update location of worrier after each step
					Thread.sleep(700);
					//System.out.println();
					
					//System.out.println(t.getName()+" leave"+currentLoc[0]+" "+currentLoc[1]);
					
					}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	 
	//}
}
