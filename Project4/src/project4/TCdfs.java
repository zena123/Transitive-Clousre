package project4;

import java.util.*;

//dfs for adjancecy matrx
class TCdfs {

    private int[][] TC;
   // private int [][]TCA;
    private int v_num;
    private int ad_matrix[][];
    private int[] v_array;
    private ArrayList <Integer> E_array;
    
    public TCdfs(Mgraph m) {
       
        v_num = m.getVerticesNum();
        ad_matrix = m.getArray();
        TC = new int [v_num][v_num]; 
   }

    public TCdfs(Agraph a) {
        v_num = a.getVerticesNum();
        v_array = a.getVertixArray();
        E_array = (ArrayList<Integer>) a.getEdgeList();
        TC = new int[v_num][v_num];
       
    }

   public TCdfs(int[][] meta_matrix) {
        v_num= meta_matrix.length;
        ad_matrix= meta_matrix;
        TC= new int [v_num][v_num];
    }

    public void mcompleteDfs() {
        for (int i = 0; i < v_num; i++) {

            mvisit(i, i);
        }
       

//        for (int i = 0; i < v_num; i++) {
//            System.out.println(Arrays.toString(TC[i]));
//        }
//         System.out.println();
        System.out.println();
    }

   
    public void mvisit(int u, int y) {
        TC[u][y] = 1;
        for (int i = 0; i < v_num; i++) {

            if (ad_matrix[y][i] == 1 && TC[u][i] == 0) {

                mvisit(u, i);
            }      }
    }

    public void acompleteDfs() {
        for (int i = 0; i < v_num; i++) {
            avisit(i, i);
          
        }

//        for (int i = 0; i < v_num; i++) {
//            System.out.println(Arrays.toString(TC[i]));
//        }
    }

    
    public void avisit(int u, int y) {
        TC[u][y] = 1;
       
        int k;
        
        for (int i = v_array[y]; i <  v_array[y+1]; i++) {
            k=E_array.get(i);
            if ( k!=-1 && TC[u][k] == 0) {

                avisit(u, k);
            }
        }
    }
    public int [][] getTcMatrix(){
    return TC;}
    
    public boolean checkReachabilityMethod(int s,int d){
    return TC[s][d]==1;
    }
    
     public void print(){
 for(int i=0;i<v_num;i++){
     System.out.println(Arrays.toString(TC[i]));
 }}
    
 
    
}