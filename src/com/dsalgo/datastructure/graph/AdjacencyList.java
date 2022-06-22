package com.dsalgo.datastructure.graph;

import com.dsalgo.datastructure.linkedlists.SinglyLinkedList;

public class AdjacencyList {

    private SinglyLinkedList[] nodeGraph;
    private int vertices;
    private int edges;

    public AdjacencyList(int nodes){
        this.vertices = nodes;
        this.edges = 0;
        this.nodeGraph = new SinglyLinkedList[nodes];
    }

    public void addEdges(int v, int u){
        if(null == this.nodeGraph[v]){
            this.nodeGraph[v] = new SinglyLinkedList();
        }
        this.nodeGraph[v].insertAtEnd(u);

        if(null == this.nodeGraph[u]){
            this.nodeGraph[u] = new SinglyLinkedList();
        }
        this.nodeGraph[u].insertAtEnd(v);

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
        for (int i = 0; i < this.nodeGraph.length; i++) {
            sb.append("\n").append(i).append(": ").append(this.nodeGraph[i]);
        }
        return sb.toString();
    }
}
