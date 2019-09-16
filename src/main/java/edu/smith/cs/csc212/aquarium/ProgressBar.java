package edu.smith.cs.csc212.aquarium;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ProgressBar {
	
	private int x=0;
	private int y=0;
	private int length=Aquarium.WIDTH;
	private Color color;
	
	public ProgressBar(Color color)
	{
		this.color=color;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		Shape bar=new Rectangle2D.Double(x, y, length, 10);
		g.fill(bar);
		g.setColor(Color.black);
		g.draw(bar);
		
	}
	
	public void change(int change)
	{
		length+=change;
	}
	


	public int getLength() {
		return length;
	}
	
		

}
