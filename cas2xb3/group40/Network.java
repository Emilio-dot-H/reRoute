package cas2xb3.group40;

import java.awt.List;
import java.util.ArrayList;

public class Network {

    private Intersection[] intsecs;
    private int nV;
    private int nE;
    private Bag<Intersection>[] adj;
	
    public Network(int cap){
        intsecs = new Intersection[cap];
    }
    public void adjInit(){
    	int k = nV;
    	adj = (Bag<Intersection>[]) new Bag[k]; //Create array of lists
        for(int v=0; v<k; v++){ // Initialize all lists
			adj[v] = new Bag<Intersection>(); // to empty
			// Just created an empty array list the same size as the # of vertices
        }
    }

    public void addIntersection(Intersection i) { //i and j are the same intersection, different types.
    	int k = i.getId();
    	intsecs[k] = i;
        nV++;
        adjInit();
        
    }
    public void edgeDetection(Intersection a, Intersection b, Intersection c){
    	double dist1 = a.getDistance(c); //distance from a to c
    	double dist2 = b.getDistance(c); //distance from b to c
    	if(dist2 < dist1 /* & both lead to the same path*/ ){
    		addEdge(a, c);
    	}
    }
    public Intersection get(int i){
    	return intsecs[i];
    }
    public void addEdge(Intersection v, Intersection w){ 
		int g = v.getId();
		int h = w.getId();
    	adj[g].add(w); //Add w to v's list.
		adj[h].add(v);// Add v to w's list 
		nE++ ;
	}
    /*
    public void addEdge(Intersection v, Intersection w){
        //Add an edge from v to w (symmetrically).
    	checkAdd(v);
    	checkAdd(w);
    	this.adj.get(v.getId()).add(w);
    	if (v != w){
    		this.adj.get(w.getID()).add(v);
    	}
    	this.nE++;
    }
    */

    public Intersection[] iterator(){
        return intsecs.clone();
    }

    public int V(){
        //Returns the number of vertices in the graph.
        return nV;
    }

    public int E(){
        //Returns the number of edges in the graph.
        return nE;
    }

    /*
    private Intersection get(String streets){
    	for (Intersection w: intsecs){
    		if (w.getId() == id) return w;
    	}
    	return null;
    }

    private void checkAdd(Intersection v){
    	for(Intersection w : this.all){
    		if (v.getID() == w.getID()) return;
    	}
    	all.add(v);
    }

    public String toString(){
        String s = this.V() + " intersections, " + this.E() + " edges\n";
        String t = "Intersections include: ";
        for (int i = 0; i < all.size(); i++){
        	t += all.get(i) + " ";
        }
        t += "\n";
        s += t;
        for (int v = 0; v < this.V(); ++v){
            s += find(v) + ": ";
            for (Intersection w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
    */

    /*
    public Iterator<Network> iterator() {
        return new ElementIterator();
    }

    class ElementIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < V();
        }

        @Override
        public Intersection next() {
            return get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    */

}