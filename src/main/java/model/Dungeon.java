package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dungeon {
    Room[][] map;
    int sizeOfMatrix;

    public Dungeon(int n){
        this.sizeOfMatrix = n;
        map = new Room[n][n];
        createMap();
        Grid grid = new Grid(n, n);
        Graph graph = grid;
        Graph Tree = RandomSearch.generateTree(graph, -1);
        createRoad(Tree);
    }

    private void createRoad(Graph Tree) {
        ArrayList<Edge> listOfEdges = new ArrayList<>();
        for (LinkedList<Edge> Nodes : Tree.adjacency){
            for (Edge edge : Nodes){
                if (!listOfEdges.contains(edge)) listOfEdges.add(edge);
            }
        }
    }

    public void createMap() {
        for (int i=0; i<=sizeOfMatrix; i++){
            for (int j=0; j<=sizeOfMatrix; j++){
                if (i==0 && j==0) map[i][j] = new CreatorRoomStart().createRoom();
                if(i == sizeOfMatrix && j == sizeOfMatrix) map[i][j] = new CreatorRoomFinish().createRoom();
                else { map[i][j] = new RandomRoom().createRandomRoom();}
            }
        }
    }
}
