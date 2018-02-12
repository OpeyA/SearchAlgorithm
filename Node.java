// The Node Class will be the block that each state resides in to be part of the data structure.
public class Node {
	
	private Node child1;
	private Node child2;
	private Node child3;
	private Node parent;
	private State nodeState;
	private int heur;

//	Constructor	
	public Node(int pCan, int pMis, char pBoat, int pHeur){
		nodeState = new State(pCan, pMis, pBoat);
		heur = pHeur;
	}
	
//	Sets all child nodes
	public void setNodeChild(Node pNode1, Node pNode2, Node pNode3){
		this.setChild1(pNode1);
		this.setChild2(pNode2);
		this.setChild3(pNode3);
	}
	
//	The following methods are the accessors and mutators needed for the Node class
	public Node getChild1(){
		return child1;
	}
	
	public void setChild1(Node pChild){
		child1 = pChild;
	}
	
	public Node getChild2(){
		return child2;
	}
	
	public void setChild2(Node pChild){
		child2 = pChild;
	}
	
	public Node getChild3(){
		return child3;
	}
	
	public void setParent(Node pNode){
		parent = pNode;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public void setChild3(Node pChild){
		child3 = pChild;
	}
	
	public State getNodeState(){
		return nodeState;
	}
	
	public void setHeur(int pHeur){
		heur = pHeur;
	}
	
	public int getHeur(){
		return heur;
	}
	
	
	
}
