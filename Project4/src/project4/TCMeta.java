 package project4;

/*

NOTES:


This class to compute chrunk/meta graph
from adjacency matrix and adjacency array.....
then we have DfsOnMetaGraph() function which execute dfs on each vertix of chrunk graph and give transitve clousre of meta graph...
** 
- checkConnactivityFunction (int s ,int d)  : if 2 vertices have the same root then returns true.. 
    if there is an edge between root_of[s] and root_of[d] in chrunk graph then returns true
else return false
" notice that  this function runs in constant time ."   انشالله يكون هيك
"notice that java initializes an array of int by zero "
**

IMPORTANT::::::  
we created chrunk and working to find Transitive clousre was on him as a matrix !!!!!!!!!!


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TCMeta {
    private TarjanScc Tscc;
    private  ImprovedTarjan1Scc Tscc1;
    private int v;
   // private int ve;
    private int e;
    private int [][] transitve_matrix;
    private int[][] meta_matrix;
    private int[][]TC_meta_matrix;
    private int[][] adj_matrix;
    private int[] root_of;
    private int[] vm_array;
    private ArrayList<Integer> roots;
    private List<Integer> em_array;
   private LinkedList<Integer>[] ad_list;
   

   private Stack<Integer> stack;
   
  public TCMeta(){
  
   }
   public void McreateMetaMatrixByTarjan( Mgraph m){
       int x,y;
    Tscc= new TarjanScc(m);
    
    Tscc.mScc(0);
    v= Tscc.getVerticesNum();
    transitve_matrix= new int [v][v]; 
    adj_matrix= Tscc.getAdmatrix();
    root_of = Tscc.getRootArray();
    roots = Tscc.getRootsOfSccs();
    meta_matrix = new int[roots.size()][roots.size()];
    
    
    
     for (int i = 0; i < adj_matrix.length; i++) {
         x = roots.indexOf(root_of[i]);
            for (int j = 0; j < adj_matrix.length; j++) {  //منشان مر ع مكونات الجذر  
                
                   
                y = roots.indexOf(root_of[j]);
                
                if (x!=y && adj_matrix[i][j] == 1 && meta_matrix[x][y] == 0) {
                     
                    meta_matrix[x][y] = 1;
                }
            }
        }  
     
    // printMeta();
     
   }
   

   public void McreateMetaMatrixByImprovedTarjan(Mgraph m){
       int x,y;
       Tscc1= new ImprovedTarjan1Scc(m);
      Tscc1.mScc(0);
      v=m.getVerticesNum();
       transitve_matrix= new int [v][v]; 
      adj_matrix=Tscc1.getAdmatrix();
      root_of=Tscc1.getRootArray();
      roots= Tscc1.getRootsOfSccs();
      meta_matrix = new int[roots.size()][roots.size()];
      for (int i = 0; i < adj_matrix.length; i++) {
         x = roots.indexOf(root_of[i]);
            for (int j = 0; j < adj_matrix.length; j++) {  //منشان مر ع مكونات الجذر  
                
                
                y = roots.indexOf(root_of[j]);
                if (x==y) {
                    meta_matrix[x][y] = 1;
                }
                else if ( adj_matrix[i][j] == 1 && meta_matrix[x][y] == 0) {
                     
                    meta_matrix[x][y] = 1;
                }
            }
        } 
        // printMeta();
      
   }
  
public void  AcreateMetaMatrixByTarjan(Agraph a){
   int x,y;
    Tscc =  new TarjanScc(a);
    v = Tscc.getVerticesNum();
     transitve_matrix= new int [v][v]; 
    vm_array=a.getVertixArray();
    em_array=a.getEdgeList();
    Tscc.aScc(0);
    root_of = Tscc.getRootArray();
    roots = Tscc.getRootsOfSccs();
    
      // System.out.println(roots.size());
    meta_matrix = new int[roots.size()][roots.size()];
    
    for(int i=0;i<vm_array.length-1;i++){
        x = roots.indexOf(root_of[i]);
        meta_matrix[x][x]=1;
        for(int j=vm_array[i];j<vm_array[i+1];j++){
            if(em_array.get(j)!=-1){
        y=roots.indexOf(root_of[em_array.get(j)]);
        if(meta_matrix[x][y]!=1 ){
            meta_matrix[x][y]=1;
}
}
    }}
    //printMeta();

}


public void ACreateMetaMatrixByImprovedTarjan(Agraph a ){
int x,y;
Tscc1= new ImprovedTarjan1Scc(a);
v= a.getVerticesNum();
 transitve_matrix= new int [v][v]; 
vm_array=a.getVertixArray();
em_array=a.getEdgeList();
Tscc1.aScc(0);
root_of = Tscc.getRootArray();
roots = Tscc.getRootsOfSccs();
meta_matrix = new int[roots.size()][roots.size()];
for(int i=0;i<vm_array.length-1;i++){
        x = roots.indexOf(root_of[i]);
        meta_matrix[x][x]=1;
        for(int j=vm_array[i];j<vm_array[i+1];j++){
            if(em_array.get(j)!=-1){
        y=roots.indexOf(root_of[em_array.get(j)]);
        if(meta_matrix[x][y]!=1 ){
            meta_matrix[x][y]=1;
}
}
    }}
//printMeta();
}


public void printMeta(){
 System.out.println(" ");
      
        System.out.println();
        for (int i = 0; i < meta_matrix.length; i++) {
          
            for (int j = 0; j < meta_matrix.length; j++) {

                System.out.print(meta_matrix[i][j]);

            }
            System.out.println();     }}

public void DfsOnMetaGraph(){
    TCdfs o= new TCdfs(meta_matrix);
    o.mcompleteDfs();
    TC_meta_matrix=o.getTcMatrix();
    
}

 public boolean checkConnactivityFunction (int s ,int d){
    // DfsOnMetaGraph();
 if(root_of[s]==root_of[d]){
 return true;}
 else if(TC_meta_matrix[root_of[s]] [root_of[d]]==1)
 {return true;}
 else
 return false;
}
 
 public void fillTransitiveMatrix(){
    
    for(int i=0;i<v;i++){
    for(int j=0;j<v;j++){
        if(checkConnactivityFunction(i,j)){
            transitve_matrix[i][j] =1;
        }
    }}
 
 }
 public boolean checkConnactivitySecondMethod(int source ,int dest){
        return transitve_matrix[source][dest] ==1;      
        
}
 
 public boolean checkConnactivityThirdMethod( int source, int dest){ 
 return checkConnactivityFunction(source,dest);
 }
 public void printT(){
 for(int i=0;i<this.v;i++){
     System.out.println(Arrays.toString(transitve_matrix[i]));
 }}

}