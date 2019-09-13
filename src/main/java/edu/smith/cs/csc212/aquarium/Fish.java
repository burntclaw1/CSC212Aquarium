package edu.smith.cs.csc212.aquarium;
import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {

	private int x;
	private int y;
	private Color color;
	private boolean isLittle;
	private boolean isFacingLeft;
	private Destination destination;
	private double stepx;
	private double stepy;
	
	public Fish(int x, int y, Color color, boolean isLittle, boolean isFacingLeft)
	{
		this.x=x;
		this.y=y;
		this.color=color;
		this.isLittle=isLittle;
		this.isFacingLeft=isFacingLeft;
		destination =new Destination((int)(Math.random()*Aquarium.WIDTH),(int)(Math.random()*Aquarium.HEIGHT));
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public boolean isFacingLeft()
	{
		return isFacingLeft;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean isLittle()
	{
		return isLittle;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	
	public void draw(Graphics2D g)
	{
		if(isLittle)
		{
			if(isFacingLeft)
			{
				DrawFish.smallFacingLeft(g, color, x, y);
			}
			else
			{
				DrawFish.smallFacingRight(g, color, x, y);
			}
		}
		else
		{
			if(isFacingLeft)
			{
				DrawFish.facingLeft(g, color, x, y);
			}
			else
			{
				DrawFish.facingRight(g, color, x, y);
			}
		}
		move();
	}
	public void move()
	{
		this.x+=1;
		this.y+=1;
	}
	
	
}
