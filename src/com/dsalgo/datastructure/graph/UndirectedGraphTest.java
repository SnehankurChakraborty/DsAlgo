package com.dsalgo.datastructure.graph;

public class UndirectedGraphTest {

    public static void main(String[] args) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(4);
        matrix.addEdge(1,2);
        matrix.addEdge(2,3);
        System.out.println(matrix);

        AdjacencyList adjacencyList = new AdjacencyList(4);
        adjacencyList.addEdges(1,2);
        adjacencyList.addEdges(2,3);
        System.out.println(adjacencyList);
    }
}
