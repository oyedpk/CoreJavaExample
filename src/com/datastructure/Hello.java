package com.datastructure;

import java.util.*;

public class Hello {
    public static void main(String[] args) {
        /*com.datastructure.BinaryTree bt=new com.datastructure.BinaryTree();
            bt.add(12);
            bt.add(13);
            bt.add(15);
            bt.add(9);
            bt.add(16);
        System.out.println("");
        bt.inOrderTraversal(bt.root);
        System.out.println("");
        bt.preOrderTraversal(bt.root);
        System.out.println("");
        bt.postOrderTraversal(bt.root);*/

        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 0));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 3));
        Graph graph = new Graph(edges);
        graph.printGraph();
        graph.dfs(2);
        System.out.println("");
        graph.bfs(2);

    }
}

