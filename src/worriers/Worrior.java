package worriers;


import java.util.ArrayList;

import MyGamePackage.Grid;
import MyGamePackage.Inhabitant;
import MyGamePackage.MagicTree;
import MyGamePackage.MyGameSetup;
import monsters.Monster;
public abstract class Worrior extends Inhabitant implements Runnable{							//implement runnable interface as need to use concurrency
	
	Thread t=new Thread(this,this.getName());													//create thread object
	public void start(){																		//this method is stand to start thread
		t.start();
	}
	
	public void run(){
		walk();																					//in run method call the walk method of worrier
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected static boolean hassomeonewon;
	protected MagicTree[] treelist=MyGameSetup.gettreelist();									//using encapsulation only subclasses of worrier can use
	protected Monster[] monstersList=MyGameSetup.getmonstlist();								//using encapsulation only subclasses of worrier can use
	private static int NumberOfWorriors=0;														//counter on number of worriers
	private boolean immotility=false;															//Immortality is set to false at beginning
	protected WalkingStick ws;
	
	
	public Worrior(String name, int[] location) {												//constructor for worrier
		super(name,location);
		mobility=true;
		NumberOfWorriors+=1;
		MyGameSetup.MountDoom.attach(this);														//when creating a worrier counter rise up
	}
	
	public static int getNumberOfWorriors(){													//getter for worrier counter
		return NumberOfWorriors;                                                                                                                                                       
	}
	
	public void setImmotility(boolean val){														//setter for immortality
		immotility=val;
	}
	
	public boolean getImmotility(){																//getter for immortality
		 return immotility;
	}
	
	public WalkingStick loseStick(){															//the method for loosing the stick
		mobility=false;																			//Mobility should be false
		WalkingStick temp=ws;
		ws=null;																				//walking stick be null
		return temp;
	}
	
	public void die(){																			//method for dyeing
		NumberOfWorriors-=1;																	//counter for worrier drop down by 1
		mobility=false;
		}
	
	public void setHasSomeOneWon(boolean val){													//setter for has some one won
		hassomeonewon=val;
	}
	
	protected synchronized void eatFruit(){														//eat fruit method
		if(!this.getImmotility()){																//check already ate fruit and became immortal
			 System.out.println(getName()+" found tree and became immortanal");					//display message
			 this.setImmotility(true);
			}
		}
	
	public abstract void walk();																//use abstraction as the way worriers walk changes
																								//i know that worrier walk but i don't know how he walk..
																								//so that i have make it abstract it and have implement in subclasses
}
