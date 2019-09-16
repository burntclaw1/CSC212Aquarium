package edu.smith.cs.csc212.aquarium;

import java.awt.Graphics2D;


public class FishFood {

	private double x=100;
	private double y=0;
	private boolean l=false;
	
    public void fall()
    {
    	if(y==Aquarium.FOODHEIGHT)
    	{
    	  y=0;
    	  l=false;
    	
    	}
    	  if(Math.random()*2<1)
    	  {
    	  x-=Math.random()*1;
    	  }
    	  else
    	  {
    		  x+=Math.random()*1;
    	  }
    	y++;
    	
    	if(y>Aquarium.FOODHEIGHT/2)
    	{
    		l=true;
    	}
    	
    }

    public void draw(Graphics2D g)
    {
    	DrawFishFood.draw(g, (int)x, (int)y);
    	fall();
    }
    
    public boolean getL()
    {
    	return l;
    }
    
	
}
