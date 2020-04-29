package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractInputData;
import org.insa.graphs.model.Graph;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        Graph graph = data.getGraph();
        
        int nbNodes = graph.size();
        // Initialize array of labels.
        Label[] labels = new Label[nbNodes];
        for (int i = 0; i<nbNodes; i++) {
        	if (this.data.getMode() == AbstractInputData.Mode.TIME) {
        		double h = (graph.get(i).getPoint().distanceTo(data.getDestination().getPoint())) / this.data.getMaximumSpeed();
        		labels[i] = new LabelStar(i, h);
        	}else {
        		double h = graph.get(i).getPoint().distanceTo(data.getDestination().getPoint());
        		labels[i] = new LabelStar(i, h);
        	}
        	
        }
        return Dijkstra(labels, graph, data);
    }
    
}
