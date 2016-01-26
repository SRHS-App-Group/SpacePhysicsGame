package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GravityObject {
	int x = 0;
	int y = 0;
	int radius = 0;
	int mass = 0;
	public GravityObject(int xcoord, int ycoord, int r, int m){
		// the given x and y are the center of the circle, processing is done in rendering to place it correctly
		this.x = xcoord;
		this.y = ycoord;
		this.radius = r;
		this.mass = m;
	}
	
	public void paint(Graphics g){ // paint is autocalled by awt
		g.setColor(Color.BLUE);
		g.fillOval(x-radius, y-radius, radius, radius);
	}
}
