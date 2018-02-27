package monsters;
import java.util.Arrays;

import worriers.WalkingStick;
import worriers.Worrior;

public class InnocentMonster extends Monster {																									     //using inheritance make sub class of monster
	
	public InnocentMonster(String name, int[] location) {																						     //Constructor for innocent monster
		super(name,location);
	}
	
	public void stealStick(Worrior worrier){																										 //implements the steal stick method
		System.out.println(worrier.getName()+" caught to innocent monster "+getName()+" and stuck in position "+Arrays.toString(this.getLocation()));//display the message
		WalkingStick walkingStick=worrier.loseStick();
		stolenSticks.add(walkingStick);//calling loose stick method of worrier
	}
	

}
