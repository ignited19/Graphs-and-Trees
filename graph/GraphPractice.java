package graph;

public class GraphPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(4);
		G.addDirectEdge(0, 1);
		G.addDirectEdge(1, 2);
		G.addDirectEdge(0, 3);
		//G.printGraph();
		//G.dfs(3, 0);
		
		Tree one = new Tree (1);
		Node two =new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		one.root.children[0]=two;
		one.root.children[1]=three;
		two.children[0]=four;
		two.children[1]=five;
		three.children[0]=six;
		three.children[1]=seven;
	
		//one.printPreorder(one.root);
		
		one.printLevel(one);

	}

}
