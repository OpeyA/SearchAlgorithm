
/* 	This is the State class. This class will hold the information for each individual 
	state of the Missionary/Cannibal problem. 
 */
public class State {
	
	private int leftCan;
	private int rightCan;
	private int leftMis;
	private int rightMis;
	private char leftBoat;
	private char rightBoat;
	
	
//	Constructor setting initial values
	public State(int pCan, int pMis, char pBoat){
		leftCan = pCan;
		rightCan = 3 - leftCan;
		leftMis = pMis;
		rightMis = 3 - leftMis;
		leftBoat = pBoat;
		if(leftBoat == 'X')
			rightBoat = 'O';
		else
			rightBoat = 'X';
	}
	
// 	Sets the string form of the State object
	public String toString(){
		String string = leftCan + "C " + leftMis + "M B" + leftBoat + " || "
				+ rightCan + "C " + rightMis + "M B" + rightBoat;
		return string;
		
	}
	
	public boolean isGoal(){
		return leftCan == 0 && leftMis == 0;
	}
	
// The following methods are the accessor methods for the State class
	public int getLeftCan(){
		return leftCan;
	}
	
	public int getRightCan(){
		return rightCan;
	}
	
	public int getLeftMis(){
		return leftMis;
	}
	
	public int getRightMis(){
		return rightMis;
	}
	
	public char getLeftBoat(){
		return leftBoat;
	}
	
	public char getRightBoat(){
		return rightBoat;
	}

}
