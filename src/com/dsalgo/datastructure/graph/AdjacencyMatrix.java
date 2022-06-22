package com.dsalgo.datastructure.graph;

public class AdjacencyMatrix {

    private int[][] matrix;
    private int edges;
    private int vertices;

    public AdjacencyMatrix(int nodes) {
        this.edges = 0;
        this.vertices = nodes;
        this.matrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        this.matrix[u][v] = 1;
        this.matrix[v][u] = 1;
        this.edges++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("edges: ")
                .append(this.edges)
                .append("vertices: ")
                .append(this.vertices)
                .append("\n");
        for (int i = 0; i < this.matrix.length; i++) {
            sb.append("\n").append(i).append(":");
            for (int w : this.matrix[i]) {
                sb.append(" ").append(w).append(" ");
            }
        }
        return sb.toString();
    }
}
