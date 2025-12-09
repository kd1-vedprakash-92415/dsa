package adjacencyList;



public class Tester {
	public class BFSDFSExample {
	    public static void main(String[] args) {
	    	AdjacencyList list = new AdjacencyList(6);

	        list.addEdge(0, 1, false);
	        list.addEdge(0, 2, false);
	        list.addEdge(1, 3, false);
	        list.addEdge(1, 4, false);
	        list.addEdge(2, 5, false);

	        System.out.println("BFS (start=0): " + list.bfs(0));
	        System.out.println("DFS Iterative (0): " + list.dfsIterative(0)); 
	        System.out.println("DFS Recursive (0): " + list.dfsRecursive(0)); 
	    }
	}
}
