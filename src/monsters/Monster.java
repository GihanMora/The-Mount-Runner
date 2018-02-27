package monsters;

import java.util.ArrayList;

import MyGamePackage.Inhabitant;
import worriers.WalkingStick;
import worriers.Worrior;

public abstract class Monster extends Inhabitant {  	  // using inheritance and abstraction as monster class doesn't create any objects
	public Monster(String name, int[] location) {   	  // constructor for monster
		super(name, location);
	}
	ArrayList<WalkingStick> stolenSticks=new ArrayList<WalkingStick>();
	public abstract void stealStick(Worrior worrier);  //abstract method of steal  stick as changes the contains in sub classes
														  // here i know that monster do steal but i don't know how monster
													      // steal...but i know how non innocent monster and innocent monster steal
													      // so that i have make steal stick abstract and have implement them specifically at subclasses

}
