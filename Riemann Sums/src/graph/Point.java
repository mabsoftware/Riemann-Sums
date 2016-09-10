package graph;

import acm.graphics.GRect;
import java.awt.Color;

public class Point extends GRect
{
	public Point(double x, double y)
	{
		super(x, y, 1, 1);
		this.setColor(Color.RED);
		this.setFillColor(Color.RED);
		this.setFilled(true);
	}
}
