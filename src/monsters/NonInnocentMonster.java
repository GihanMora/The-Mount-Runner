package monsters;

import java.util.Arrays;

import worriers.WalkingStick;
import worriers.Worrior;

public class NonInnocentMonster extends Monster{															//use inheritance and make sub class of monster
	
	public NonInnocentMonster(String name,int[] location){													//constructor for non innocent monster
		super(name,location);
	}
	
	public void kill(Worrior w){																			//method for kill a worrier
		if(!w.getImmotility()==true){																		//check first is the worrier immortal
		System.out.println(w.getName()+" caught to non innocent monster "+ getName()+" and dead");			//display message that worrier dead
		w.die();																							//call die method of worrier
		System.out.println("Number of Remaining worrirors : "+Worrior.getNumberOfWorriors());				//display remaining number of worriers
		w=null;																								//delete the particular worrier object
		}
	}
	
	public void stealStick(Worrior worrier){																	//non innocent also kill the worrier thus no need to print walking stick has stolen
		System.out.println(worrier.getName()+" caught to innocent monster "+getName()+" and stuck in position "+Arrays.toString(this.getLocation()));//display the message
		WalkingStick walkingStick=worrier.loseStick();	
		stolenSticks.add(walkingStick);																		//calling loose stick method of worrier
	}
}
