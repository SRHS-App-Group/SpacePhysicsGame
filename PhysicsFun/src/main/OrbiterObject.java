package main;

import java.awt.Color;
import java.awt.Graphics;
import main.PhysicsConstants;
import main.Vector;

public class OrbiterObject {
	double x = 0;
	double y = 0;
	int radius = 0;
	int mass = 0;
	Vector velocity;
	Vector acceleration;
	public OrbiterObject(int xcoord, int ycoord, int r, int m, Vector velocity, Vector acceleration){
		// the given x and y are the center of the circle, processing is done in rendering to place it correctly
		this.x = xcoord;
		this.y = ycoord;
		this.radius = r;
		this.mass = m;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}
	
	public Vector getGravityForce(GravityObject gravObj){
		Vector Distance = new Vector(gravObj.x-this.x,gravObj.y-this.y);
		return Vector.scalarMultiplication(PhysicsConstants.GRAVITY_CONSTANT*this.mass*gravObj.mass/(Distance.MagnitudeSquared()*Distance.Magnitude()),Distance);	
	}
	public void processPhysics(double deltat){
		this.x = x + (this.velocity.x* deltat);
		this.y = y+ (this.velocity.y* deltat);
		this.velocity.x = this.velocity.x + this.acceleration.x*deltat;
		this.velocity.y = this.velocity.y + this.acceleration.y*deltat;
	}
	
	public void paint(Graphics g){ // paint is autocalled by awt
		g.setColor(Color.RED);
		g.fillOval((int) x-radius, (int) y-radius, radius, radius);
	}
}
