package MyGamePackage;
public abstract class Inhabitant { 													// abstract class for inhabitants as we don't create any instances of it
	private String name; 															// using encapsulation and make name private and hide from other classes
	private int[] location = new int[2]; 											// using encapsulation and make location private and hide from other classes
	protected boolean mobility;

	public Inhabitant(String name, int[] location) { 								// constructor for  inhabitant
		setName(name);
		this.location = location;
		mobility = true;
	}

	public String getName() { 														// getter for name
		return name;
	}

	public void setName(String name) { 												// setter for name
		this.name = name;
	}

	public void setLocation(int[] location) { 										// setter for location
		this.location = location;
	}

	public void setMobility(boolean mobility) { 									// setter for mobility
		this.mobility = mobility;
	}

	public int[] getLocation() { 													// getter for location
		return location;
	}
}
