package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Dungeon {
    Room[][] map;
    int sizeOfMatrix;

    public Dungeon(int n){
        this.sizeOfMatrix = n;
        map = new Room[n][n];
        Random rand = new Random();
        createMap(rand);
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

    public void createMap(Random rand) {
        for (int raw=0; raw<=sizeOfMatrix-1; raw++){
            for (int column=0; column<=sizeOfMatrix-1; column++){
                if (raw==0 && column==0) map[raw][column] = new CreatorRoomStart().createRoom(rand);
                if(raw == sizeOfMatrix-1 && column == sizeOfMatrix-1) map[raw][column] = new CreatorRoomFinish().createRoom(rand);
                else { map[raw][column] = new RandomRoom().createRandomRoom();}
            }
        }
    }
}
