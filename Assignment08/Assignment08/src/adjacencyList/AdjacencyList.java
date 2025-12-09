package adjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
	    private int vertices;
	    private List<List<Integer>> adj;

	    // Constructor
	    public AdjacencyList(int vertices) {
	        this.vertices = vertices;
	        adj = new ArrayList<>(vertices);
	        for (int i = 0; i < vertices; i++) {
	            adj.add(new ArrayList<>());
	        }
	    }

	    // Add an edge (undirected by default)
	    public void addEdge(int u, int v, boolean directed) {
	        adj.get(u).add(v);
	        if (!directed) {
	            adj.get(v).add(u);
	        }
	    }

	    // BFS traversal from a given start vertex
	    public List<Integer> bfs(int start) {
	        boolean[] visited = new boolean[vertices];
	        Queue<Integer> queue = new LinkedList<>();
	        List<Integer> result = new ArrayList<>();

	        visited[start] = true;
	        queue.offer(start);

	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            result.add(node);

	            for (int neighbor : adj.get(node)) {
	                if (!visited[neighbor]) {
	                    visited[neighbor] = true;
	                    queue.offer(neighbor);
	                }
	            }
	        }
	        return result;
	    }

	    // DFS traversal — iterative version
	    public List<Integer> dfsIterative(int start) {
	        boolean[] visited = new boolean[vertices];
	        Stack<Integer> stack = new Stack<>();
	        List<Integer> result = new ArrayList<>();

	        stack.push(start);

	        while (!stack.isEmpty()) {
	            int node = stack.pop();
	            if (!visited[node]) {
	                visited[node] = true;
	                result.add(node);

	                // Push neighbors in reverse order to maintain natural left-to-right visit order
	                List<Integer> neighbors = adj.get(node);
	                for (int i = neighbors.size() - 1; i >= 0; i--) {
	                    int neighbor = neighbors.get(i);
	                    if (!visited[neighbor]) {
	                        stack.push(neighbor);
	                    }
	                }
	            }
	        }
	        return result;
	    }

	    // DFS traversal — recursive version
	    public List<Integer> dfsRecursive(int start) {
	        boolean[] visited = new boolean[vertices];
	        List<Integer> result = new ArrayList<>();
	        dfsUtil(start, visited, result);
	        return result;
	    }

	    private void dfsUtil(int v, boolean[] visited, List<Integer> result) {
	        visited[v] = true;
	        result.add(v);
	        for (int neighbor : adj.get(v)) {
	            if (!visited[neighbor]) {
	                dfsUtil(neighbor, visited, result);
	            }
	        }
	    }

	    // Optional: Print adjacency list (for debugging)
	    public void printGraph() {
	        for (int i = 0; i < vertices; i++) {
	            System.out.println(i + " -> " + adj.get(i));
	        }
	    }
	}

