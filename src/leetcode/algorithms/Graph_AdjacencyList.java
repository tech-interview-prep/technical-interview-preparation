package leetcode.algorithms;

import java.util.ArrayList;

public class Graph_AdjacencyList {
    private ArrayList<ArrayList<Integer>> list;
    private int numOfVertices;

    public Graph_AdjacencyList(int n) {
        numOfVertices = n;
        list = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0 ; i <= n; i++)
            list.add(new ArrayList<Integer>());
    }

    public int size() {
        return numOfVertices;
    }

    public void addEdge(int v1, int v2) {
        list.get(v1).add(v2);
    }

    public void removeEdge(int v1, int v2) {
        int i2 = list.get(v1).indexOf(v2);
        list.get(v1).remove(i2);
    }

    public ArrayList<ArrayList<Integer>> getLists() {
        return list;
    }

    public ArrayList<Integer> neighbours(int index) {
        return list.get(index);
    }

    public void setLists(ArrayList<ArrayList<Integer>> newList) {
        list = newList;
    }
}
