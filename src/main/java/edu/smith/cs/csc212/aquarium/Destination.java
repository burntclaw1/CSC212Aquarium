package edu.smith.cs.csc212.aquarium;

public class Destination {

	private double x;
	private double y;
	public Destination(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public double getDX()
	{
		return x;
	}
	public double getDY()
	{
	return y;
	}
	
	public String toString()
	{
		return x+", "+y;
	}
	
}
