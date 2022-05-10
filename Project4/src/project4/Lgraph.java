package project4;


/*
just an implemntation of adjacency list
*/

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Lgraph {

    private int vertix_num;
    private int edge_num;
    private LinkedList<Integer> adjListArray[];

    // constructors 
    Lgraph() {
    }

    public Lgraph(int vertix_num) {

        this.vertix_num = vertix_num;

        this.adjListArray = new LinkedList[this.vertix_num];

        // Create a new list for each vertex
        for (int i = 0; i < this.vertix_num; i++) {
            this.adjListArray[i] = new LinkedList<>();
        }
    }

    public void setEdgeNum(int edge_num) {
        this.edge_num = edge_num;
    }

    public void setVerticesNum(int vertix_num) {
        this.vertix_num = vertix_num;
        this.adjListArray = new LinkedList[this.vertix_num];
        for (int i = 0; i < this.vertix_num; i++) {
            this.adjListArray[i] = null;
        }

    }

    public int getVerticesNum() {
        return this.vertix_num;
    }

    public int getEdgesNum() {
        return this.edge_num;
    }

    public LinkedList<Integer>[] getAdarray() {
        return adjListArray;
    }

    // Adds an edge to an undirected graph
    public void addEdges(int source_vertix, int dest_vertix) {

        adjListArray[ source_vertix].add(dest_vertix);

    }

    public void addEdgefile() throws FileNotFoundException {

        File file = new File("C:\\Users\\DELL-\\Desktop\\input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            adjListArray[i].add(j);
        }

    }

    public void removeEdge(int source_vertix, int dest_vertix) {
        Iterator<Integer> it = adjListArray[source_vertix].iterator();
        while (it.hasNext()) {
            if (it.next() == dest_vertix) {
                it.remove();
                return;
            }
        }
    }

    //  function to print the adjacency list 
    public void printGraph() {

        for (int i = 0; i < this.vertix_num; i++) {
            if (adjListArray[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < adjListArray[i].size(); j++) {
                    System.out.print(adjListArray[i].get(j) + " ");
                }
                System.out.println();
            }
        }
        System.out.println(adjListArray.length);
    }
}
