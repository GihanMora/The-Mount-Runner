package MyGamePackage;

import java.util.ArrayList;

import worriers.Worrior;

public class Mount {
	ArrayList<Worrior> observers = new ArrayList<Worrior>();						//The mount is always observing by worriers

	public void attach(Worrior worrior) {											// method to attach worriers as observers
		observers.add(worrior);
	}

	public void detach(Worrior worrior) {											// method to detach worriers as observers
		observers.add(worrior);
		observers.remove(worrior);
	}

	public void notifyAllWorriors() {												//method for notify observers that someone has reached the mountain
		for (Worrior worrier : observers) {
			worrier.setHasSomeOneWon(true);
			worrier.setMobility(false);
			;

		}

	}
}
