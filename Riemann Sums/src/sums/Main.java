package sums;

import acm.program.GraphicsProgram;

import java.awt.Color;
import acm.graphics.GLabel;
import graph.Graph;

public class Main extends GraphicsProgram
{
	private Graph g;
	private GLabel AreaLabel;
	
	public static void main(String args[])
	{
		new Main().start();
	}
	
	public void init()
	{
		this.setSize(320 * 3, 240 * 3);
		this.setTitle("Riemann Sums Visualization");
		
		AreaLabel = new GLabel("");
		AreaLabel.setLocation(20, 20);
		AreaLabel.setColor(Color.GREEN);
		this.add(AreaLabel);
		
		g = new Graph(this, 0.5, AreaLabel);
	}
	
	public void run()
	{
		while (true)
		{
			g.draw(0.5);
			this.waitForClick();
		}
		
	}
}
