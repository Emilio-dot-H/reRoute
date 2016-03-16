package cas2xb3.group40;

import java.util.ArrayList;


public class Intersection{

    private static int intersectionNum = 0;

	private double x, y;
	private String streets;
	private int id;

	public Intersection(String s, double x, double y){
		this.streets = s;
        this.x = x;
        this.y = y;
		this.id = intersectionNum++;
	}

	public double getX() {
        return x; //
	}

	public double getY() {
        return y;
    }
	public double getDistance(Intersection a, Intersection b){ //returns distance between 2 intersections
		double x1 = a.getX(); //x coordinate of the first intersection (Intersection a)
		double y1 = a.getY(); //y coordinate of the first intersection (Intersection a)
		double x2 = b.getX(); //x coordinate of the second intersection (Intersection b)
		double y2 = b.getY(); //y coordinate of the second intersection (Intersection b) 
		double dist_pyth = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		return dist_pyth;
	}

	public String getStreets() {
		return this.streets;
	}

	public int getId() {
		return this.id;
	}

	public String toString() {
		return "[" + streets + "]";
	}

}

	public String toString() {
		return "[" + streets + "]";
	}

}
