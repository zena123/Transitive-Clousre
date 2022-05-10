package project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class ImprovedTarjan1Scc {
      
       private boolean[] in_component; 
       private int [] low_root;     // root array in psudo code
       private int[] dfs_num;
       private ArrayList roots;
       private int[] root_of;
       
       private int counter=0;
       Stack<Integer> stack=new Stack<Integer>();
       private int[][] ad_matrix;
       private int v_num;
       private int[] v_array;
       private List<Integer> e_array;
       
       
       // counstructor for adjancecy matrix
     public ImprovedTarjan1Scc(Mgraph m){
         v_num=m.getVerticesNum();
         ad_matrix=m.getArray();
         in_component= new boolean[v_num];
         low_root=new int[v_num]; 
         dfs_num= new int [v_num];
         root_of = new int[v_num];
         roots = new ArrayList<Integer>();
         for(int i=0;i<v_num;i++){
             dfs_num[i]=-1;}
         
        //stack.push(-3);   // !stack.is empty gives exception without pushing this value
     } 
     
     // for adjacency array......
     
     public ImprovedTarjan1Scc(Agraph a) {
        v_num = a.getVerticesNum();
        v_array = a.getVertixArray();
        e_array = a.getEdgeList();
        in_component = new boolean[v_num];
        low_root = new int[v_num];
        dfs_num= new int [v_num];
        root_of = new int[v_num];
        roots = new ArrayList<Integer>();
        for (int i = 0; i < v_num; i++) {
            dfs_num[i] = -1;
        }
        stack.push(0);
    }
     
      public int[] getRootArray() {
        return root_of;}    // get roots of sccs
      
      public int [][] getAdmatrix(){
          return ad_matrix;}   // get adjacency matrix
      
      

    public ArrayList<Integer> getRootsOfSccs() {
        return roots;
    }
     
     
     public void mvisit(int v){
        
       
      dfs_num[v]=low_root[v]=counter++;
     for(int w=0;w<v_num;w++){
         if(ad_matrix[v][w]!=0){
     if(dfs_num[w]==-1){
         mvisit(w);}
     
     if( !in_component[w]){
         low_root[v]=Math.min(low_root[v], low_root[w]);} }
}
     
     
     if(low_root[v]==dfs_num[v]){
         roots.add(v);
         root_of[v]=v;
         
        
     in_component[v]=true;
    
       int k;
     while(! stack.isEmpty() && dfs_num[stack.peek()]>dfs_num[v]){     // what if stack is always empty?????
         k=stack.pop();
        root_of[k] = v;
         in_component[k]=true;
     }
   
    }
     
     else{stack.push(v);}
     }
     
     
      public void avisit(int v) {
        int k = 0;
        dfs_num[v]=low_root[v]=counter++;
        in_component[v] = false;
        for (int i = v_array[v]; i < v_array[v + 1]; i++) {
            k = (int) e_array.get(i);
            if (k == -1) {
                break;
            } else if ( dfs_num[k] == -1) {
                avisit(k);
            }

            if (!in_component[k] && k != -1) {
                low_root[v] = Math.min(low_root[v], low_root[k]);
            }
        }
        if (low_root[v] == dfs_num[v]) {
             roots.add(v);
             root_of[v]=v;           
            in_component[v] = true;
            while (! stack.isEmpty() && dfs_num[stack.peek()]>dfs_num[v]) {       // what if stack is always empty???????????????????????????
                int l = stack.pop();
                root_of[l] = v;
                in_component[l] = true;
            }
        } else {
            stack.push(v);
        }
    }
      
      
     
     // for adjacency matrix
     public void mScc(int x){
         mvisit(x);
         
     for(int i=0;i<v_num;i++){
     if ( dfs_num[i]==-1){
     mvisit(i);}}
     System.out.println(Arrays.toString(low_root));
     System.out.println(Arrays.toString(root_of));
}
     
     
      public void aScc(int x) {
          avisit(x);
        for (int i = 0; i < v_num; i++) {
            if (dfs_num[i] == -1) {
                avisit(i);
            }
        }
        System.out.println(Arrays.toString(low_root));
        System.out.println(Arrays.toString(root_of));
    }
}