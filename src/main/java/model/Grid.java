package model;
import java.util.BitSet;
import java.util.Iterator;


public class Grid extends Graph {

	int width;
	int height;
	int maxVertex;
	
	/*Graph graph;*/
	
	public int abscissaOfVertex(int vertex) {
		return vertex % width;
	}
	
	public int ordinateOfVertex(int vertex) {
		return vertex / width;
	}
	
	private int vertexOfCoordinate(int abscissa, int ordinate) {
		return ordinate * width + abscissa;
	}
	
	public Grid(int width, int height) {
		super(width*height);
		this.width = width;
		this.height = height;
		maxVertex = width * height - 1;
		/*graph = new Graph(maxVertex);*/
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i < width - 1)
					/*graph.*/addEdge(new Edge(
									vertexOfCoordinate(i,j),
									vertexOfCoordinate(i+1,j),
									0.0
							));

				if (j < height - 1)
					/*graph.*/addEdge(new Edge(
									vertexOfCoordinate(i,j),
									vertexOfCoordinate(i,j+1),
									0.0
						));
			}
		}
		
	}

	
	public boolean isHorizontal(Edge e) {
		return Math.abs(e.source - e.dest) == 1;
	}
	
	public boolean isVertical(Edge e) {
		return Math.abs(e.source - e.dest) == width;
	}


	private void drawLine(int h, BitSet right) {
		for (int i = 0; i < this.width - 1; i++) {
			System.out.print(h * width + i);
			if (right.get(vertexOfCoordinate(i, h))) System.out.print(" ↔ ");
			else System.out.print("  ");
		}
		System.out.println(h * width + width - 1);
	}

	private void drawInterline(int h, BitSet up) {
		for (int i = 0; i < this.width; i++) {
			if (up.get(vertexOfCoordinate(i, h))) System.out.print("↕ ");
			else System.out.print(" ");
			if (i < this.width - 1) System.out.print("  ");
		}
		System.out.println();
	}

	
}
