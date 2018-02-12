import java.util.*;

public class Search {
	
	
	// This method uses Breadth-First Search and takes a node as an argument and then prints path and 
	// number of nodes explored, and returns the goal node
	public static Node BFS(Node initial){
		if(initial.getNodeState().isGoal()){
			System.out.println("The initial node is the goal");
			System.out.println("The path is: " + initial);
			System.out.println("Number of nodes explored: 1");
			return initial;
		}
		LinkedList<Node> list = new LinkedList<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		LinkedList<Node> explored = new LinkedList<Node>();
		list.add(initial);
		while(!list.isEmpty()){
			Node tempNode = list.poll();
			explored.add(tempNode);
			if(!tempNode.getNodeState().isGoal()){
				if(tempNode.getChild1() != null && !list.contains(tempNode.getChild1()))
					list.add(tempNode.getChild1());
				if(tempNode.getChild2() != null && !list.contains(tempNode.getChild2()))
					list.add(tempNode.getChild2());
				if(tempNode.getChild3() != null && !list.contains(tempNode.getChild3()))
					list.add(tempNode.getChild3());
			}
			else{
				System.out.println("The path is: ");
				Node parentNode = tempNode.getParent();
				path.add(tempNode);
				while(parentNode != null){
					path.add(parentNode);
					parentNode = parentNode.getParent();
				}
				
				
				for (int i = path.size() - 1 ; i >= 0 ; i--) {
					System.out.println(path.get(i).getNodeState());
				    
				}
				System.out.println("The number of steps along the path is: " + path.size());
				System.out.println("The number of nodes explored is: " + explored.size());
				return tempNode;
			}			
		
		
	}
		System.out.println("The state could not be found.");
		return null;
	}
	
	// This method uses Best-First Search and takes a node as an argument and then prints path and 
	// number of nodes explored, and returns the goal node
	public static Node BestFirst(Node initial){
		if(initial.getNodeState().isGoal()){
			System.out.println("The initial node is the goal");
			System.out.println("The path is: " + initial);
			System.out.println("Number of nodes explored: 1");
			return initial;
		}
		ArrayList<Node> list = new ArrayList<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		LinkedList<Node> explored = new LinkedList<Node>();
		list.add(initial);
		while(!list.isEmpty()){
			
			Node tempNode = heurCheck(list);
			list.remove(tempNode);
			explored.add(tempNode);
			
			if(!tempNode.getNodeState().isGoal()){
				if(tempNode.getChild1() != null && !list.contains(tempNode.getChild1()))
					list.add(tempNode.getChild1());
				if(tempNode.getChild2() != null && !list.contains(tempNode.getChild2()))
					list.add(tempNode.getChild2());
				if(tempNode.getChild3() != null && !list.contains(tempNode.getChild3()))
					list.add(tempNode.getChild3());
			}
			else{
				System.out.println("The path is: ");
				Node parentNode = tempNode.getParent();
				path.add(tempNode);
				while(parentNode != null){
					path.add(parentNode);
					parentNode = parentNode.getParent();
				}
				
				
				for (int i = path.size() - 1 ; i >= 0 ; i--) {
					System.out.println(path.get(i).getNodeState());
				    
				}
				System.out.println("The number of steps along the path is: " + path.size());
				System.out.println("The number of nodes explored is: " + explored.size());
				return tempNode;
			}
		}
		System.out.println("The state could not be found.");
		return null;
	}
	

	
	// This method determines which child is the optimal path based on heuristic value
	public static Node heurCheck(ArrayList<Node> list){
		int bestHeur = list.get(0).getHeur();
		Node bestNode = list.get(0);
		for(Node item : list){
			if(bestHeur > item.getHeur()){
				bestHeur = item.getHeur();
				bestNode = item;
			}
		}
		return bestNode;
		

	}
	
	
	// Main Method
	public static void main(String[] args) {
		// Introduction to the program and the initial state
		System.out.println("Welcome to the program! This program will be used"
				+ "to solve the classic Missionaries and Cannibals problem.");
		Node initialNode = new Node(3, 3, 'O', 11);
		System.out.println("The initial state of the problem is: " + initialNode.getNodeState() +"\n");
		System.out.println("The numbers before C and M each represent the number of cannibals and missionaries respectively.\n"
				+ "To determine where the boat is located, there is the letter B and then either an X or O.\n"
				+ "The O determines where the boat is while the X represents where it is not.\n");
		System.out.println("This program will attempt to complete this problem using 2 different search algorithms.\n"
				+ "The algorithms are Breadth-First Search and Best-First Search\n");
		
		//Creating the nodes
		Node node2 = new Node(2, 3, 'X', 12);
		Node node3 = new Node(2, 2, 'X', 10);
		Node node4 = new Node(1, 3, 'X', 10);
		Node node5 = new Node(2, 3, 'O', 9);
		Node node6 = new Node(0, 3, 'X', 8);
		Node node7 = new Node(1, 3, 'O', 7);
		Node node8 = new Node(1, 1, 'X', 6);
		Node node9 = new Node(2, 2, 'O', 5);
		Node nodeA = new Node(2, 0, 'X', 4);
		Node nodeB = new Node(3, 0, 'O', 3);
		Node nodeC = new Node(1, 0, 'X', 2);
		Node nodeD = new Node(2, 0, 'O', 1);
		Node nodeE = new Node(1, 1, 'O', 1);
		Node nodeF = new Node(0, 0, 'X', 0);
		
		//Setting the leaves of each node
		initialNode.setNodeChild(node2, node3, node4);
		node2.setNodeChild(null, null, null);
		node3.setNodeChild(node5, null, null);
		node4.setNodeChild(node5, null, null);
		node5.setNodeChild(node6, null, null);
		node6.setNodeChild(node7, null, null);
		node7.setNodeChild(node8, null, null);
		node8.setNodeChild(node9, null, null);
		node9.setNodeChild(nodeA, null, null);
		nodeA.setNodeChild(nodeB, null, null);
		nodeB.setNodeChild(nodeC, null, null);
		nodeC.setNodeChild(nodeD, nodeE, null);
		nodeD.setNodeChild(nodeF, null, null);
		nodeE.setNodeChild(nodeF, null, null);
		nodeF.setNodeChild(null, null, null);
		
		//Setting parents of Nodes
		initialNode.setParent(null);
		node2.setParent(initialNode);
		node3.setParent(initialNode);
		node4.setParent(initialNode);
		node5.setParent(node3);
		node6.setParent(node5);
		node7.setParent(node6);
		node8.setParent(node7);
		node9.setParent(node8);
		nodeA.setParent(node9);
		nodeB.setParent(nodeA);
		nodeC.setParent(nodeB);
		nodeD.setParent(nodeC);
		nodeE.setParent(nodeC);
		nodeF.setParent(nodeD);
		
		
		
		// Run BFS
		System.out.println("We are now starting the BFS");
		BFS(initialNode);
		System.out.println("BFS has been completed\n");
		
		// Run Best-First Search
		System.out.println("We are now starting Best-First Search");
		BestFirst(initialNode);

		System.out.println("\nThanks for using this program. Goodbye now!!!!");
	}

}
