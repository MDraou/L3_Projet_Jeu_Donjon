package model.graph;
import java.util.BitSet;


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
		for (int raw = 0; raw < width; raw++) {
			for (int column = 0; column < height; column++) {
				if (raw < width - 1)
					/*graph.*/addEdge(new Edge(
									vertexOfCoordinate(raw,column),
									vertexOfCoordinate(raw+1,column),
									0.0
							));

				if (column < height - 1)
					/*graph.*/addEdge(new Edge(
									vertexOfCoordinate(raw,column),
									vertexOfCoordinate(raw,column+1),
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
		for (int index = 0; index < this.width - 1; index++) {
			System.out.print(h * width + index);
			if (right.get(vertexOfCoordinate(index, h))) System.out.print(" ↔ ");
			else System.out.print("  ");
		}
		System.out.println(h * width + width - 1);
	}

	private void drawInterline(int h, BitSet up) {
		for (int index = 0; index < this.width; index++) {
			if (up.get(vertexOfCoordinate(index, h))) System.out.print("↕ ");
			else System.out.print(" ");
			if (index < this.width - 1) System.out.print("  ");
		}
		System.out.println();
	}

	
}
