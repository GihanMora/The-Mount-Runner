package MyGamePackage;

import java.util.Arrays;

import worriers.Worrior;

public  class Grid {
	static Node[][] myGrid=new Node[11][11];
	
	public void setGrid(){
		
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				myGrid[i][j]=new Node();
			}
		}
		
		for(int k=0;k<5;k++){
			int x=MyGameSetup.getmonstlist()[k].getLocation()[0];
			int y=MyGameSetup.getmonstlist()[k].getLocation()[1];
			myGrid[x][y].setNode(0, MyGameSetup.getmonstlist()[k]);
		}
		for(int p=0;p<5;p++){
			int x=MyGameSetup.gettreelist()[p].getLocation()[0];
			int y=MyGameSetup.gettreelist()[p].getLocation()[1];
			myGrid[x][y].setNode(0, MyGameSetup.gettreelist()[p]);
			
		}
		for(int m=0;m<4;m++){
			int x=MyGameSetup.worriorsList[m].getLocation()[0];
			int y=MyGameSetup.worriorsList[m].getLocation()[1];
			myGrid[x][y].setNode(0, MyGameSetup.worriorsList[m]);
			
		}
		myGrid[5][5].setNode(0, MyGameSetup.MountDoom);
	}
	/*public void printGrid(){
		setGrid();
		for(int t=0;t<11;t++){
			for(int u=0;u<11;u++){
				if(myGrid[t][u]==null){System.out.print(" "+"________");}
				else{
					Object o=myGrid[t][u];
					if(o instanceof Inhabitant){System.out.print(" "+((Inhabitant) o).getName());}
					if(o instanceof MagicTree){System.out.print(" "+((MagicTree) o).getName());}
					
				}}
			System.out.println();
		}
		
	}*/
	public void setGridPoint(int x, int y,Object o){
		myGrid[x][y].setNode(1, o);;
	}
	public void clearGridPoint(int x, int y,int position){
		myGrid[x][y].clearNode();;
	}
	public static Object getGridPoint(int x,int y,int position){
		return myGrid[x][y].getNode(position);
	}
	public static Object getCell(int x,int y){
		return myGrid[x][y];
	}
	

}
