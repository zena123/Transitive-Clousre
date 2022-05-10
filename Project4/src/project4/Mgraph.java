
package project4;

// graph representation Using Adjacency Matrix

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

 class Mgraph {
    private  int E;
     private   int V ;
     private int[][] Adg_matrix;
     
    public Mgraph(int vertices_num){
         if (vertices_num < 0) {throw new RuntimeException("......Number of vertices must be non negative.......");}
         else{ this.E=0; 
     this.V=vertices_num;
     Adg_matrix=new int [this.V][this.V];
     for (int i=0;i<this.V;i++){
     for(int j=0;j<this.V;j++){
     Adg_matrix[i][j]=0;}
     }}}
     
     
     public Mgraph(File f) throws FileNotFoundException{
      Scanner sc = new Scanner(f);
         int begin,end;
         this.V= sc.nextInt();
         this.E= sc.nextInt();
         Adg_matrix= new int[V][V];
         
         for(int i=0;i<V;i++){
             begin=sc.nextInt();
             end=sc.nextInt();
             while(end!=-2 && end != -1){
           this.addEdge(begin, end);
           end=sc.nextInt();
             }
     }}         
     
     /*
     for random graph .... this method creates random graph for 
     adjacency matrix then writes the graph in a file so that we create random graph 
     for adjacency array
     */
     public Mgraph (int V, int E, File ff ) throws FileNotFoundException{
       File f= new File("E:\\share it\\D2302\\file\\Project4\\randomGraphMatrix.txt");
     PrintWriter Pw= new PrintWriter(f);
     this.V=V;
     this.E=E;
     Pw.println(this.V);
     Pw.println(this.E);
     
     
     if (E< 0) throw new RuntimeException("Number of edges mustnot be negative");
        if (E> V*V) throw new RuntimeException("Too many edges..maximum is V*V ");
        Adg_matrix= new int[V][V];
        int counter=0;
        while(counter<E){
        int source= (int) (Math.random() * V);
        int dest= (int) (Math.random() * V);
        if(source!=dest){
            Pw.print(source);
            Pw.print(" ");
            Pw.print(dest);
            Pw.println();
        this.addEdge(source, dest);
        counter++;}}
        Pw.close();
       // File f= new File("randomGraph.txt");
        PrintWriter PW= new PrintWriter(ff);
        PW.print(this.V);
        PW.print(" ");
        PW.println(this.E);
        int c;
        for(int i=0;i<this.V;i++){
             c=0;
             PW.print(i);
             PW.print(" ");
            for(int j=0;j<this.V;j++){
                if(Adg_matrix[i][j]==1){
               PW.print(j);
                PW.print(" ");
                c++;}}
            if(c==0){
            PW.print(-1);
            PW.print(" ");}
            
            PW.println(-2); }
        
        
        
    PW.close();
        }
     
    // Add seters and geters 
     public void setEdgeNum(int edges_num1){
    E=edges_num1;}
     
     public int  getEdgeNum(){ return E;}
     
     public int [][] getArray(){
     return Adg_matrix;
     }
    
    
     
     public int getVerticesNum()  {return this.V;}
     
    // Add an edge method........    O(1)
     public void addEdge(int source_vertix, int dest_vertix){
        try{
      
        Adg_matrix[ source_vertix][dest_vertix]=1;}
         catch(Exception index){
         System.out.println("no such vertices");}
     }
     
      //remove  an edge method........    O(1)
     public void removeEdge(int source_vertix, int dest_vertix){
         try{
         Adg_matrix[ source_vertix][dest_vertix]=0;}
         catch(ArrayIndexOutOfBoundsException index){
         System.out.println("no such vertices");}}
     
     //a method to print the Adjacency Matrix
     public void printMgraph(){
          for (int i=0;i<this.V;i++){
           for(int j=0;j<this.V;j++){
             System.out.print(Adg_matrix[i][j]+" ");
     }
           System.out.println("");}
     }
     
     // a method to tell what are the vertices connected to a given vertix
     public void getConnections(int vertix_num){
     if( this.V<= vertix_num)
     {
      JOptionPane.showMessageDialog(null,"there is no such vertix"); }
     else{
     String v="";
     
     for(int i=0;i<this.V;i++){
     if( Adg_matrix[vertix_num][i]==1)
         v+=""+i+" ";
      }
      JOptionPane.showMessageDialog(null,"vertix "+vertix_num+" is connected to vertices :"+v);
     }}
            
}
