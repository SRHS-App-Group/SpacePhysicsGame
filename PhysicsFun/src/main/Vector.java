package main;

public class Vector {
	double x;
	double y;
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double dotProduct(Vector v1, Vector v2){
		return v1.x*v2.x + v1.y+v2.y;
	}
	public static double Magnitude(Vector v){
		return Math.sqrt(Math.pow(v.x, 2)+Math.pow(v.y, 2));
	}
	public double Magnitude(){
		return Magnitude(this);
	}
	public static double MagnitudeSquared(Vector v){
		return Math.pow(v.x, 2)+Math.pow(v.y, 2);
	}
	public double MagnitudeSquared(){
		return MagnitudeSquared(this);
	}
	public static Vector scalarMultiplication(double scalar,Vector v){
		return new Vector(scalar*v.x,scalar*v.y);
	}
	public static Vector vectorAddition(Vector v1, Vector v2){
		return new Vector(v1.x+v2.x,v1.y+v2.y);
	}
	// wont have cross product because this is a 2D vector 
}
