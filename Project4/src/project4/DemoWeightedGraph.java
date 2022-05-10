
 package project4;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableDirectedWeightedGraph;

public class DemoWeightedGraph {

    private static void createAndShowGui() {
        JFrame frame = new JFrame("DemoGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ListenableGraph<String, MyEdge> g = buildGraph();
        JGraphXAdapter<String, MyEdge> graphAdapter
                = new JGraphXAdapter<String, MyEdge>(g);

        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        frame.add(new mxGraphComponent(graphAdapter));

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    public static class MyEdge extends DefaultWeightedEdge {

        public MyEdge() {
            super();
        }
         double weight;
         
         protected double getWeight(){
          return this.weight;   
         }
         
         protected void setWeight(double weight){
           this.weight = weight;   
         }
         
         
        @Override
        public String toString() {
            return String.valueOf(getWeight());
        }
    }

    public static ListenableGraph<String, MyEdge> buildGraph() {
        ListenableDirectedWeightedGraph<String, MyEdge> g
                = new ListenableDirectedWeightedGraph<String, MyEdge>(MyEdge.class);

        String x1 = "x1";
        String x2 = "x2";
        String x3 = "x3";
        String x4 = "x4";
        String x5 = "x5";
        String x6 = "x6";
        String x7 = "x7";
        String x8 = "x8";
        String x9 = "x9";
        

        g.addVertex(x1);
        g.addVertex(x2);
        g.addVertex(x3);
        g.addVertex(x4);
        g.addVertex(x5);
        g.addVertex(x6);
        g.addVertex(x7);
        g.addVertex(x8);
        g.addVertex(x9);
        

        MyEdge e = g.addEdge(x1, x2);
        g.setEdgeWeight(e, 1);
        e = g.addEdge(x2, x3);
        g.setEdgeWeight(e, 2);

        e = g.addEdge(x3, x1);
        g.setEdgeWeight(e, 3);
        
         e = g.addEdge(x3, x4);
        g.setEdgeWeight(e, 5);
        
         e = g.addEdge(x4, x5);
        g.setEdgeWeight(e, 3);
        
         e = g.addEdge(x4, x6);
        g.setEdgeWeight(e, 7);
        
         e = g.addEdge(x6, x7);
        g.setEdgeWeight(e, 3);
        
         e = g.addEdge(x7, x8);
        g.setEdgeWeight(e, 3);
        
        e = g.addEdge(x7, x9);
        g.setEdgeWeight(e, 3);

        return g;
    }
}
