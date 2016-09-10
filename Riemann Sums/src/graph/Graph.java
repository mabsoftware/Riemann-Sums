package graph;


import java.util.List;
import acm.graphics.GLabel;
import sums.Main;
import java.util.ArrayList;

public class Graph
{
	private Main myProgram;
	private int z = 50;
	private double precision;
	private List<RiemannRectangle> riemannRectangles;
	private GLabel label;
	
	public Graph(Main program, double myPrecision, GLabel gL)
	{
		myProgram = program;
		precision = myPrecision;
		riemannRectangles = new ArrayList<RiemannRectangle>();
		label = gL;
	}
	
	public void draw(double precision)
	{
		this.clearRects(riemannRectangles.size());
		this.drawRects();
		this.drawFunction();
		label.setLabel("" + this.getApproximateAreaUnderCurve());
	}
	
	public void clearRects(int n)
	{
		for (int i = 0; i < n; i++)
		{
			myProgram.remove(riemannRectangles.get(i));
		}
		for (int i = 0; i < n; i++)
		{
			riemannRectangles.remove(0);
		}
	}
	
	public void drawRects()
	{
		for (double i = 0; i < myProgram.getWidth(); i += z)
		{
			riemannRectangles.add(new RiemannRectangle(i, z, myProgram));
		}
		
		for (int i = 0; i < riemannRectangles.size(); i++)
		{
			myProgram.add(riemannRectangles.get(i));
		}
		z /= 1.01;
	}
	
	public void drawFunction()
	{
		for (double i = 0; i < myProgram.getWidth(); i += precision)
		{
			myProgram.add(new Point(i, myProgram.getHeight() - function(i)));
		}
	}
	
	public double getApproximateAreaUnderCurve()
	{
		double sum = 0;
		System.out.println(riemannRectangles.size());
		for (int i = 0; i < riemannRectangles.size(); i++)
		{
			sum += riemannRectangles.get(i).getArea();
		}
		System.out.println(sum);
		return sum;
	}
	
	public static double function(double x)
	{
		return 0.001 * x * x;
	}
}
