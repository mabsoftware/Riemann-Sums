package graph;

import acm.graphics.GRect;
import sums.Main;

public class RiemannRectangle extends GRect
{
	public RiemannRectangle(double x, double l, Main program)
	{
		super(x, program.getHeight() - Graph.function(x), l, Graph.function(x));
		program.add(this);
	}
	
	public double getArea()
	{
		return this.getWidth() * this.getHeight();
	}
}
