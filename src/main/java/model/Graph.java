package model;
import java.util.*;


public class Graph{

	int order;
	int edgeCardinality;
	
	ArrayList<LinkedList<Edge>> adjacency;
	
	public boolean isVertex(int vertex) {
		return adjacency.size() > vertex ? adjacency.get(vertex) != null : false ;
	}
	
	public <T> ArrayList<LinkedList<T>> makeList(int size) {
		ArrayList<LinkedList<T>> res = new ArrayList<>(size);
		for(int i = 0; i <= size; i++) {
			res.add(null);
		}
		return res;
	}
	
	public Graph(int upperBound) {
		this.order = 0;
		this.adjacency = makeList(upperBound);
	}
	
	public void addVertex(int indexVertex) {
		if (!isVertex(indexVertex)) {
			adjacency.set(indexVertex, new LinkedList<Edge>());
			order++;
		}
	}

	
	public void addEdge(Edge e) {
		addVertex(e.dest);
		addVertex(e.source);
		adjacency.get(e.dest).add(e);
		adjacency.get(e.source).add(e);
	}
	
	public List<Edge> neighbours(int vertex) {
		return this.adjacency.get(vertex);
	}


	public int degree(int vertex) {
		return neighbours(vertex).size();
	}

	public int getOrder() { return order; }
	

	
	public boolean isEdge(Edge e) {
		return this.adjacency.get(e.dest).contains(e);
	}

	
	public void removeEdge(Edge e) {
		if (this.isEdge(e)) {
			this.adjacency.get(e.dest).remove(e);
			this.adjacency.get(e.source).remove(e);
			edgeCardinality--;
		}
	}	
	
	public void removeVertex(int vertex) {
		for (Edge e : neighbours(vertex)) {
			removeEdge(e);
		}
		adjacency.set(vertex, null);
	}

	public void show() {
		System.out.println("Order : " + this.order + "\nEdges :");
		HashSet<Edge> set = new HashSet<>();
		for (int vertex = 0 ; vertex < order ; vertex++)
			if (isVertex(vertex))
				for (Edge edge : this.neighbours(vertex))
					if (! set.contains(edge)) {
						set.add(edge);
						System.out.println("* " + edge);
					}
	}
	
}
