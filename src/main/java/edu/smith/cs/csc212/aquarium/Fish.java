package edu.smith.cs.csc212.aquarium;
import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {

	private double x;
	private double y;
	private Color color;
	private boolean isLittle;
	private boolean isFacingLeft;
	private Destination destination;
	private double stepx=0.5;
	private double stepy;
	
	public Fish(double x, double y, Color color, boolean isLittle, boolean isFacingLeft)
	{
		this.setX(x);
		this.setY(y);
		this.color=color;
		this.isLittle=isLittle;
		this.isFacingLeft=isFacingLeft;
		setDestination(new Destination((int)(Math.random()*Aquarium.WIDTH),(int)(Math.random()*Aquarium.HEIGHT)));
		determineStep();
		System.out.println(destination);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public boolean isFacingLeft()
	{
		return isFacingLeft;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
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
				DrawFish.smallFacingLeft(g, color, (int)getX(), (int)getY());
			}
			else
			{
				DrawFish.smallFacingRight(g, color, (int)getX(), (int)getY());
			}
		}
		else
		{
			if(isFacingLeft)
			{
				DrawFish.facingLeft(g, color, (int)getX(), (int)getY());
			}
			else
			{
				DrawFish.facingRight(g, color, (int)getX(), (int)getY());
			}
		}
		move(Aquarium.WIDTH, Aquarium.HEIGHT);
	}
	public void move(int maxx, int maxy)
	{
		if(Math.abs(x-destination.getDX())<=2||Math.abs(y-destination.getDY())<=2)
		{
			newDest((int)(Math.random()*maxx)+1,(int)(Math.random()*maxy)+1);
			System.out.println(destination);
			determineStep();

		}
		x+=stepx;
		y+=stepy;
		
	}
	
	
	
	public void newDest(int maxx, int maxy)
	{
		if(maxx>Aquarium.WIDTH||maxy>Aquarium.HEIGHT)
			throw new RuntimeException("Not in the aquarium!");
		setDestination(new Destination((int)(Math.random()*maxx)+1,(int)(Math.random()*maxy)+1));
	}
	
	public void determineStep()
	{
		if(destination.getDX()-x==0)
		{
			stepx=0;
			if(destination.getDY()-y>0)
			{
				stepy=0.5;
			}
			else
			{
				stepy=-0.5;
			}
			return;
		}
		
		if(destination.getDX()-x>0&&destination.getDY()-y>=0)
		{
			isFacingLeft=false;
			stepx=0.5;
			stepy=Math.abs((stepx/(destination.getDX()-x))*(destination.getDY()-y));
		}
		else if(destination.getDX()-x<0&&destination.getDY()-y>=0)
		{
			isFacingLeft=true;
			stepx=-0.5;
			stepy=Math.abs((stepx/(destination.getDX()-x))*(destination.getDY()-y));
		}
		else if(destination.getDX()-x<0&&destination.getDY()-y<=0) //!
		{
			isFacingLeft=true;
			stepx=(-0.5);
			stepy=-1*Math.abs((stepx/(destination.getDX()-x))*(destination.getDY()-y));
		}
		else//!
		{
			isFacingLeft=false;
			stepx=0.5;
			stepy=-1*Math.abs((stepx/(destination.getDX()-x))*(destination.getDY()-y));
		}
		
	}

	
	public void setColor(Color color)
	{
		this.color=color;
	}

	public double getStepx() {
		return stepx;
	}

	public void setStepx(double stepx) {
		this.stepx = stepx;
	}
	public double getStepy() {
		return stepy;
	}

	public void setStepy(double stepy) {
		this.stepy = stepy;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	

}
