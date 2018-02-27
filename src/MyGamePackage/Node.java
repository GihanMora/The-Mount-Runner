package MyGamePackage;

import java.util.ArrayList;

public class Node {											
	Object[] cell = new Object[2];								//cell is an array that can contain 2 objects,one is static otherone is dynamic

	public void clearNode() {									//method for clear the dynamic location
		cell[1] = null;
	}

	public void setNode(int position, Object o) {				//method for placing objects in the cell
		cell[position] = o;
	}

	public Object getNode(int position) {						//method for get the object of the cell
		return cell[position];
	}

}
