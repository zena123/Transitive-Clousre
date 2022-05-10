package project4;

import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
public class Project4 {

   
    public static void main(String[] args) throws FileNotFoundException {
         double x,y,z;
//        Mgraph MatGraph= new Mgraph(8,9);
         File file=new File("E:\\share it\\D2302\\file\\Project4\\randomGraph.txt");
          File fil=new File("E:\\share it\\D2302\\file\\Project4\\randomGraphMatrix.txt");
       // File fff=file;
        Mgraph m= new Mgraph(2000,1280000,file);
      //  Mgraph m= new Mgraph(file);
      Agraph a = new Agraph(file);
       TCMeta t= new TCMeta();
        x= System.nanoTime();
     t.AcreateMetaMatrixByTarjan(a);
     t.DfsOnMetaGraph();
     t.fillTransitiveMatrix();
     y= System.nanoTime();
     z= (y-x);
     System.out.println("first method: "+z);
     
       
        
//         TCdfs u = new TCdfs(m);
//         
//         x= System.nanoTime();
//         u.mcompleteDfs();
//         y= System.nanoTime();
//         z= (y-x);
//      System.out.println("first method: "+z);
//      
//      
//      x= System.nanoTime();
//     boolean o= u.checkReachabilityMethod(0,0);
//      y=System.nanoTime();
//      
//         z= (y-x);
//      System.out.println("true1: "+" "+o+" "+z);
//      
//       x= System.nanoTime();
//     o= u.checkReachabilityMethod(0,1);
//      y=System.nanoTime();
//      
//         z= (y-x);
//      System.out.println("false1: "+" "+o+" "+z);
//      
//      
//      TCMeta t= new TCMeta();
//      x= System.nanoTime();
//      t.McreateMetaMatrixByTarjan(m);
//      t.DfsOnMetaGraph();
//      y= System.nanoTime();
//         z= (y-x);
//      System.out.println("second method:   "+z);
//      
//      
//      
//       x= System.nanoTime();
//     o= t.checkConnactivityThirdMethod(0,2);
//      y= System.nanoTime();
//         z= (y-x);
//      System.out.println("true2  "+" "+o+" "+z);
//      
//      
//      
//       x= System.nanoTime();
//     o= t.checkConnactivityThirdMethod(0,1);
//      y= System.nanoTime();
//         z= (y-x);
//      System.out.println("false2  "+" "+o+" "+z);
//      
      
      
      
      //u.print();
        // Agraph a= new Agraph (fil);
         
       //  TarjanScc c= new  TarjanScc(MatGraph);
        //  TarjanScc cc= new  TarjanScc(a);
         //c.mvisit(8);
//         double x= System.nanoTime();
//         cc.aScc(8);
//         double y= System.nanoTime();
//         double z=y-x;
//         System.out.println(z/1000000);
//        // System.exit(0);
        // Warshall w= new Warshall(MatGraph);
        // w.computeTcFromAdMatrix();
        // w.printTcMatrix();
      // Agraph aa= new Agraph(fil);
       
        // TCdfs f= new TCdfs(MatGraph);
         // TCdfs tf= new TCdfs(aa);
         // f.mcompleteDfs();
          //tf.acompleteDfs();
          
         
       
        
   
      
        //c.DfsOnMetaGraph();
       // c.fillTransitiveMatrix();
        //c.printT();
        
       // c.AcreateMetaMatrixByTarjan(aa);
         
        
//        Agraph a= new Agraph (file);
//        a.print(); 
       /*  Scanner sc = new Scanner(file);
         int begin,end;
         int v= sc.nextInt();
         int e= sc.nextInt();
         Mgraph MatGraph= new Mgraph(v);
         for(int i=0;i<e;i++){
             begin=sc.nextInt();
             end=sc.nextInt();
              MatGraph.addEdge(begin,end);*/
       //  }
        // MatGraph.getConnections(0);
         // Agraph a= new Agraph(file);
          //Mgraph  MatGraph = new Mgraph(file);
       
       //ImprovedTarjan1Scc j =new ImprovedTarjan1Scc(MatGraph);
       //j.mvisit(8);
       //j.mScc();
       
        //ImprovedTarjan1Scc g =new ImprovedTarjan1Scc(aa);
       //g.avisit(0);
       //g.aScc();
      // TCdfs w= new TCdfs(a);
     // w.acompleteDfs();
       //j.aScc();
        
//       System.out.println();
      //TarjanScc t= new TarjanScc(MatGraph);
      //t.mvisit(4);
       //t.mScc();
       
      
    
       
          
      // Scanner s = new Scanner(System.in);
       /*String s= sc.next();
       int x=sc.nextInt();
         
      
        Mgraph MatGraph= new Mgraph();
        MatGraph.setVerticesNum(x);
       
        while (s!="s"){
            
          int a= sc.nextInt();
          int b= sc.nextInt();
         
          if (b>= x || a>=x){
             {
              JOptionPane.showMessageDialog(null,"out of bounds");}}
          
         
          else   MatGraph.addEdge(a,b);
           
        }
        MatGraph.printMgraph();
    }}*/

// Mgraph MatGraph= new Mgraph(9);
//     MatGraph.addEdge(0,1);
//     MatGraph.addEdge(0,5);
//       MatGraph.addEdge(1,3);
//       MatGraph.addEdge(1,4);
//       MatGraph.addEdge(3,0);
//       MatGraph.addEdge(3,6);
//       MatGraph.addEdge(6,0);
//       MatGraph.addEdge(4,5);
//       MatGraph.addEdge(5,2);
//       MatGraph.addEdge(2,4);
//           MatGraph.addEdge(7,2);
//      
//        MatGraph.addEdge(7,8);
//         MatGraph.addEdge(8,2);
//         MatGraph.addEdge(8,7);
//           TcMetaDfs t2= new TcMetaDfs(MatGraph);
//         t2.getMetaMatrix();
//          TarjanScc t= new TarjanScc(MatGraph);
//      
//       t.mScc();
      /* MatGraph.getConnections(0);
       MatGraph.printMgraph();
       MDfsScc j =new MDfsScc(  MatGraph);
       j.completeDfs();*/
// System.out.print("Enter the number of vertices  ");
//         int v = s.nextInt();
//         System.out.print("Enter the number of edges  ");
//         int e = s.nextInt();
//     
//      Agraph a= new Agraph(v,e);
//     int source=0;
//     while(source<v){
//         
//       source=s.nextInt();
//        int dest=s.nextInt();
//       if(source<v){
//     
//      a.addEdge(source, dest);
//      
//     }}
//    a.print();
//       
 }}
