package com.datastructure;

import java.util.*;

class Edge {
    int src,dest;
    Edge(int src,int dest) {
        this.src=src;
        this.dest=dest;
    }
}
public class Graph {
    List<List<Integer>> adj_list = new ArrayList<List<Integer>>();

    Graph(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++) {
            adj_list.add(new ArrayList<Integer>());
        }
        for (Edge edge : edges) {
            adj_list.get(edge.src).add(edge.dest);
        }
    }

    void printGraph() {
        for (int i = 0; i < adj_list.size(); i++) {
            for (Integer dest : adj_list.get(i)) {
                System.out.print("com.datastructure.Edge: " + i + "->" + dest + ", ");
            }
            System.out.println("");
        }
    }

    void dfs(int v) {
        boolean[] visited = new boolean[adj_list.size()];
        dfs(v, visited);
    }

    void dfs(int v, boolean[] visited) {
        if (!visited[v])
            visited[v] = true;
        System.out.print(v + " ");
        for (Integer x : adj_list.get(v)) {
            if(visited[x])
                return;
            dfs(x, visited);
        }
    }

    void bfs(int v) {
        Queue<Integer> queue=new LinkedList<Integer>();
        boolean[] visited = new boolean[adj_list.size()];
        queue.add(v);
        while(!queue.isEmpty()) {
            v=queue.poll();
            visited[v]=true;
            System.out.print(v+" ");
            for(Integer x:adj_list.get(v)) {
                if(!visited[x])
                queue.add(x);
            }
        }
    }

}

