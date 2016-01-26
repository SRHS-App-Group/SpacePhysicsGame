package main;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import main.Vector.*;

public class Run extends JFrame{
	
	// Dimensional Constants
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	public static final Color CANVAS_BG_COLOR = Color.DARK_GRAY;
	public static final double deltat = .050;
	public static final long rate = 30;

	// overall rate = deltat/rate*1000
	
	public static int gravObjCount = 0;

	DrawCanvas canvas;
	GravityObject gravityObject;
	GravityObject[] gravityObjects;
	OrbiterObject orbiterObject;
	
	public Run(){

		gravityObject = new GravityObject(FRAME_WIDTH/2,FRAME_HEIGHT/2,40,400);
		orbiterObject = new OrbiterObject(300,FRAME_HEIGHT/2,20,1,new Vector(0,50),new Vector(0,0));
		// set up drawing canvas
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		
		
		
		// add to JFrame
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas,BorderLayout.CENTER);
		// FOR UI LATER
		// cp.add(buttonPanel, BorderLayout.SOUTH) 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Physics Simulation");
		pack();
		setVisible(true);
		requestFocus();
		canvas.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				gravityObjects[gravObjCount] = new GravityObject(e.getX(),e.getY(),40,400);
				gravObjCount++;
				
		
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Thread updateThread = new Thread(){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(rate);
						orbiterObject.processPhysics(deltat);
						orbiterObject.acceleration = (orbiterObject.getGravityForce(gravityObject));
						repaint();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		};
		updateThread.start();
		
	}
	class DrawCanvas extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			gravityObject.paint(g);
			orbiterObject.paint(g);
		}
	}

	public static void main(String[] args) {
		// Create UI
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Run();
				
			}
		});
		
		
		
	}

}
