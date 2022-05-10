package project4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import static java.lang.Math.min;


//scc by tarjan
class TarjanScc {

  
    private final int v_num;
    private int[] low_link;
    private int[] dfs_num;
    private int dfs_counter = 0;
   // private int scc_count;
    private ArrayList roots;
    private int[] root_of;
    private boolean [] in_stack;
    private int[] v_array;
    Stack<Integer> stack = new Stack<Integer>();
    private List<Integer> e_array;
    private LinkedList<Integer>[] ad_list;
    private int ad_matrix[][];
    private Lgraph l;
   // Stack<Integer> stack = new Stack<Integer>();

    public TarjanScc(Mgraph m) {
        
        v_num = m.getVerticesNum();
        ad_matrix = m.getArray();           //can i use it without new matrix???????????
        dfs_num = new int[v_num];
        low_link = new int[v_num];
        //scc_count=-1;
       // l = new Lgraph(v_num);
        root_of = new int[v_num];
        in_stack= new boolean[v_num];
        roots = new ArrayList<Integer>();
//       ad_list = l.getAdarray();
         for (int i = 0; i < v_num; i++) {
            dfs_num[i] = -1;
        }
    }

    

    public TarjanScc(Agraph a) {
        v_num = a.getVerticesNum();
        dfs_num = new int[v_num];
       // scc_count=-1;
        low_link = new int[v_num];
        in_stack= new boolean[v_num];
        // stack = new Stack<Integer>();
       // stack.push(-2);
        v_array = a.getVertixArray();
        e_array = a.getEdgeList();
        l = new Lgraph(v_num);
         roots = new ArrayList<Integer>();
        root_of = new int[v_num];
        for (int i = 0; i < v_num; i++) {
            dfs_num[i] = -1;
        }
    }
    
    public LinkedList<Integer>[] getAdjList() {
        return ad_list;}  

    public int[] getRootArray() {
        return root_of;}    // get roots of sccs
    
  

    public ArrayList<Integer> getRootsOfSccs() {
        return roots;
    }
      public int [][] getAdmatrix(){
    return ad_matrix;}   // get adjacency matrix
    
    public int getVerticesNum(){
        return v_num;}
    
   
    
    
   //  visti for adjacency matrix
    private void mvisit(int u) {

       
        stack.push(u);
        in_stack[u]=true;
        dfs_num[u] = low_link[u] = dfs_counter++;

       for(int i=0;i<v_num;i++){
        if(ad_matrix[u][i]==1){
            if(dfs_num[i]==-1){
                mvisit(i);
                low_link[u]=Math.min(low_link[u], low_link[i]);           
            } else if(dfs_num[i]<dfs_num[u]){
                if(in_stack[i]){   //
                low_link[u]=Math.min(low_link[u], low_link[i]);
                }           }                   
       }        }   
         
        

        if (low_link[u] == dfs_num[u]) {
           roots.add(u);
            for (int n = stack.pop();; n = stack.pop()) {
               // l.addEdges(u, n);
               in_stack[n]=false;
                root_of[n] = u;
                if (n == u) {
                    break;
                }
            }        
        } 
    }
    
    //
    public void avisit(int u) {
        int k;
       
        
        
        stack.push(u);
        in_stack[u]=true;
        
        dfs_num[u] = low_link[u]=dfs_counter++;
        
        for (int i = v_array[u]; i < v_array[u + 1]; i++) {

            k =  e_array.get(i);
             if (k == -1) {

                break; //no connected vertix...dfs[-1] : X
            }
           else if ( dfs_num[k] == -1) {

                avisit(k);

                low_link[u] = min(low_link[u], low_link[k]);
            } else if (dfs_num[k] < dfs_num[u] && k != -1) //cross or backword edge
            {
                if (in_stack[k]) {
                    low_link[u] = Math.min(low_link[u], dfs_num[k]);
                }    // or low_link[i]
            }
        }

        if (low_link[u] == dfs_num[u]) {
            roots.add(u);
            for (int n = stack.pop();; n = stack.pop()) {
                in_stack[n]=false;
                l.addEdges(u, n);
                root_of[n] = u;
                if (n == u) {
                    break;
                }

            }
        }
    }

    public void mScc(int x) {
        mvisit(x);
        
        for (int i = 0; i < v_num; i++) {
            if (dfs_num[i] == -1) {
                mvisit(i);
               }
        }
//        System.out.println(Arrays.toString(low_link));
//        System.out.println(Arrays.toString(root_of));
//      
        
    }

    public void aScc(int x) {
        avisit(x);

        for (int i = 0; i < v_num; i++) {
            if (dfs_num[i] == -1) {
                avisit(i);          
            }
        }
        //l.printGraph();
         System.out.println(Arrays.toString(low_link));
        System.out.println(Arrays.toString(root_of));
    }
   // public int getSccCount(){return scc_count;}

}
