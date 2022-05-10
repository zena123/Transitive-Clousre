package project4;

/*
# this class is to create adjacency array
*/

import java.io.*;
import java.util.*;

public class Agraph {

    private int E;
    private int V;
    private int count_e;
     private int count_v;
    private int[] v_array;
    private List<Integer> E_array;

    public Agraph() { }

    public Agraph(int V, int E) {
        this.V = V;
        this.E = E;
        count_e=0;
        count_v=0;
        E_array = new ArrayList<Integer>(E);
        v_array = new int[V + 1];
        
    }
    
     public  Agraph(File f) throws FileNotFoundException {

        Scanner sc = new Scanner(f);
//        int source, size;
           this.V  = sc.nextInt();
           this.E=sc.nextInt();
     
        v_array = new int[V + 1];
        E_array = new ArrayList<Integer>();
       // v_array[0] = 0;
        
        int j=0;
        int s;
        int d;
        for(int i=0;i<V;i++) {
            //c=Integer.parseInt(sc.next());
            s=sc.nextInt();
            d=sc.nextInt();
             //System.out.println(sc.next());
            while(d!=-2){                     
             E_array.add(d);
            j++;
             d=sc.nextInt();
             }
            v_array[i+1]=j;
            
        }
    }

   

    public int getEdgeNum() {
        return E;
    }

    public int getVerticesNum() {
        return V;
    }

    public int[] getVertixArray() {
        return v_array;
    }
    public List<Integer> getEdgeList(){
    return E_array;}

    public void addEdge(int source, int dest) {

//        if (size == 0) {
//            v_array[source + 1] = v_array[source] + 1;
//            E_array.add(v_array[source], -1);
//
//        } else {
//            v_array[source + 1] = v_array[source] + size;
//            int i = 0;
//            for (int j = v_array[source]; j < v_array[source + 1]; j++) {
//
//                E_array.add(j, dest[i]);
//                i++;
//            }
         E_array.add(count_e, dest);
             //System.out.println(E_array.get(count_e));
             count_e++;
//
          
         v_array[source+1 ] = count_e;
         
          
            
          }
        

    public void print() {

        int h;
        for (int i = 0; i < V; i++) {
            System.out.println("the connected vertex with  (( " + i + " )) is: ");

            for (int j = v_array[i]; j < v_array[i + 1]; j++) {
                h = E_array.get(j);
                if (h == -1) {
                    System.out.println("     their are no outedges from it  ");
                } else {
                    System.out.print("     " + h);
                }
            }
            System.out.println();

        }
    }

}
