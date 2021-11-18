package model.graph;
import java.util.*;

public class RandomSearch {
    public static Graph generateTree(Graph graph, int i) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Edge> randomTree = new ArrayList<>();
        Random rand = new Random();
        Edge e;
        int edgeIndex;

        int source = i == -1 ? rand.nextInt(graph.getOrder()) : i;
        set.add(source);
        List<Edge> border = new ArrayList<>(List.copyOf(graph.neighbours(source)));
        //Test pour faire en sorte que la final room soit différente de la start room
        System.out.println(source);

        while (set.size() < graph.getOrder()) {

            /*System.out.println("========== " + border.size());
            for (var v : border) System.out.println(v);*/

            edgeIndex = rand.nextInt(border.size());
            e = border.get(edgeIndex);
            randomTree.add(e);

            //Test pour faire en sorte que la final room soit différente de la start room
            if (set.size() == graph.getOrder()-1 && set.contains(e.source)) System.out.println("final room(dest) = "+e.dest);
            if (set.size() == graph.getOrder()-1 && set.contains(e.dest)) System.out.println("final room(source) = "+e.source);

            if (set.contains(e.dest)) set.add(e.source);
            else set.add(e.dest);
            border.clear();

            for (int j : set) {
                //System.out.println("*" + j);
                for (Edge edge : graph.neighbours(j)) {
                    //System.out.println(edge);
                    if (!set.contains(edge.dest)) border.add(edge);
                    if (!set.contains(edge.source)) border.add(edge);
                }
            }
        }

        Graph graph1 = new Graph(randomTree.size());
        for (Edge edge : randomTree) graph1.addEdge(edge);
        return graph1;
    }
}
