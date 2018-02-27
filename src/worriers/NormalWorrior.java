package worriers;
import java.util.ArrayList;
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

public class NormalWorrior extends Worrior { 													// using inheritance of worrier
	public NormalWorrior(String name, int[] location) { 										// constructor for normal worrier
		super(name, location);
	}
	
	public void walk() { 	
		try {
			Random randomNumber = new Random();
			int x = this.getLocation()[0];
			int y = this.getLocation()[1]; 														// x and y coordinates of the location
			System.out.println(this.getName()+" Started the battle of running "+x+" "+y);		//displaying that this worrier has started the battele	
			
			while (mobility && !hassomeonewon) { 												// check whether mobility true and has someone won already
				
				synchronized(MyGameSetup.LandOFModor.getCell(x, y)){							//synchronized each step and uses lock as the current cell
				//System.out.println(t.getName()+"took"+x+" "+y);
				//System.out.println();
				int direction = randomNumber.nextInt(2);
				int[] currentLoc = { x, y };
				if(MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof MagicTree){			//if static position of current cell has a tree
					this.eatFruit();}
				if(MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof InnocentMonster){	//if static position of current cell has a innocentMonster
					((InnocentMonster) MyGameSetup.LandOFModor.getGridPoint(x, y,0)).stealStick(this);}
				if(MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof NonInnocentMonster){ //if static position of current cell has a non innocent monster
					((NonInnocentMonster)MyGameSetup.LandOFModor.getGridPoint(x, y,0)).kill(this);}
				if (MyGameSetup.LandOFModor.getGridPoint(x, y,0) instanceof Mount){ 			//if static position of current cell has mount doom
					synchronized(MyGameSetup.MountDoom){	
					MyGameSetup.MountDoom.notifyAllWorriors();	
					Thread.sleep(800);
					System.out.println(getName() + " Climbed the mountain and won!!!"); 		// display that worrier climbed the mountain
					System.out.println("<<<<<Game Finished!!!>>>>>");
					}
				}
				MyGameSetup.LandOFModor.clearGridPoint(x, y, 1);								//clear the dynamic position of previous cell
				if (x <= 5 && y <= 5) { 														// if worrier is in left down side of the grid step by step his 
					if (direction == 0) {														// x coordinate increment and y coordinate increment
						x += 1;
					} else {
						y += 1;
					}
				} else if (x <= 5 & y >= 5) { 													// if worrier is in right down side of the grid step by step his
					if (direction == 0) {														// x coordinate increment and y coordinate decrement
						x += 1;
					} else {
						y -= 1;
					}
				} else if (x >= 5 && y >= 5) { 													// if worrier is in right up side of the grid step by step his
					if (direction == 0) {														// x coordinate decrement and y coordinate decrement
						x -= 1;
					} else {
						y -= 1;
					}
				} else if (x >= 5 && y <= 5) { 													// if worrier is in left up side of the grid step by step his 
					if (direction == 0) {														// x coordinate decrement and y coordinate increment
						x -= 1;
					} else {
						y += 1;
					}
				}
				if( MyGameSetup.LandOFModor.getGridPoint(x, y,1) instanceof Worrior){
					x = currentLoc[0]; 															// if that so this worrier remains previous x coordinate
					y = currentLoc[1];}
				int[] newlocation={x,y};
				this.setLocation(newlocation);
				MyGameSetup.LandOFModor.setGridPoint(x, y, this);
				
				if(!hassomeonewon && mobility){
					System.out.println(getName() + " walking to " + x + " " + y);}
				Thread.sleep(700);
				//System.out.println();
				
				//System.out.println(t.getName()+" leave"+currentLoc[0]+" "+currentLoc[1]);
				}
		}
				
				
			
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
