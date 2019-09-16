package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;
	
	public static int FOODWIDTH=200;
	public static int FOODHEIGHT=200;
	int i=0;
	

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");
Fish fish=new Fish(getWidth()+10,300,Color.cyan,false,false);
Fish fish1=new Fish(getWidth()+100,200,Color.yellow,false,true);
Fish fish2=new Fish(getWidth()+300,300,Color.green,false,false);
Fish fish3=new Fish(getWidth()+300,300,Color.green,true,false);
HungryFish fish4 = new HungryFish(getWidth()+20, 300, Color.DARK_GRAY,true,false);




	
	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());

		
		//fish.draw(g);
		//fish1.draw(g);
		//fish2.draw(g);
		//fish3.draw(g);
		fish4.draw(g);
		
/*
		if(i>=lol.size())
		{
			i=0;
		}
		for(int z=0;z<=i;z++)
		{
			if(lol.get(z)!=null)
			lol.get(z).draw(g);

		}
		i++;
		*/
		
		// Draw our snail!
		algorithm.draw(g);

		// Move the fish!

		
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
