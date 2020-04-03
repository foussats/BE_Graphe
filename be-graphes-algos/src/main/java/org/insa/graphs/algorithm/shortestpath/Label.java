package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label implements Comparable<Label> {
	private double cost;
	private int node;
	private boolean connu;
	private Arc pere;
	
	public Label(int node) {
		this.node = node;
		this.cost = Double.POSITIVE_INFINITY;
		connu = false;
		pere = null;
	}
	
	public int sommetCourant() {
		return this.node;
	}
	
	public boolean inconnu() {
		return !this.connu;
	}
	
	public void setConnu(boolean connu) {
		this.connu = connu;
	}
	
	public Arc getPere() {
		return this.pere;
	}
	
	public void setPere(Arc pere) {
		this.pere = pere;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getCost() {
		return this.cost;
	}
	

    public int compareTo(Label label) {
    	if (this.cost == label.cost) {
    		return 0;
    	}
    	else if (this.cost<label.cost){
    		return -1;
    	}
    	else {
    		return 1;
    	}

    }
}