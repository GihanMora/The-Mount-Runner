package MyGamePackage;
public class MagicTree {
	private String name; 																// using encapsulation for name
	private int[] location = new int[2]; 												// using encapsulation for location

	public MagicTree(String name, int[] location) { 									// constructor for magic tree
		this.setName(name);
		this.location = location;
	}

	public int[] getLocation() { 														// getter for location
		return location;
	}

	public String getName() { 															// getter for name
		return name;
	}

	public void setName(String name) { 													// setter for name
		this.name = name;
	}

}
