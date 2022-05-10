package project4;

import java.util.ArrayList;
import java.util.Arrays;


class Warshall {
    
    private int Tc[][];
    private final int v_num;
    private int ad_matrix[][];
  
    public Warshall( Mgraph m){
        v_num = m.getVerticesNum();
        ad_matrix = m.getArray();
        Tc= new int [v_num][v_num];         
    }
    
    
    
    public void computeTcFromAdMatrix(){
    
        for(int i=0;i<v_num;i++){
            System.arraycopy(ad_matrix[i], 0, Tc[i], 0, v_num);
}
       for(int k=0;k<v_num;k++){
           for(int i=0;i<v_num;i++){
               for(int j=0;j<v_num;j++){
              Tc[i][j] = (Tc[i][j]!=0) || ((Tc[i][k]!=0) && (Tc[k][j]!=0))?1:0;
               }          
           }
       }      
    }
    
    public int [][] getTCMatrix(){
    return Tc;}
    
    
    public boolean checkReacability( int s, int d){
    return Tc[s][d]==1;}
    
    
    
    public void printTcMatrix(){
     for (int i = 0; i < v_num; i++) {
            System.out.println(Arrays.toString(Tc[i]));
           
    }
      System.out.println();
            System.out.println();
    
}
}
