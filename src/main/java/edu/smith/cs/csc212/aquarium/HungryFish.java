package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class HungryFish extends Fish {
	
	private int hungerMeter=0;
	boolean i=false;
	private Color temp;
	private int alt;
	private int count=0;
	private ProgressBar progress=new ProgressBar(Color.yellow);
	private ProgressBar back=new ProgressBar(Color.DARK_GRAY);
    public ArrayList<FishFood> fishFood;
    private int s=0;
	

	public HungryFish(double x, double y, Color color, boolean isLittle, boolean isFacingLeft)
			{
		super(x, y, color, isLittle, isFacingLeft);

		fishFood=new ArrayList<FishFood>();
		temp=color;
		alt=temp.getRed();
		for(int z=0;z<2;z++)
		{
			fishFood.add(new FishFood());
		}
			}
	
	//broken
	public void move(int maxx, int maxy)
	{
		
		
		
			System.out.println(hungerMeter);
			if(hungerMeter>500)
			{
				if(i==false)
				{
					newDest(Aquarium.FOODWIDTH, Aquarium.FOODHEIGHT);
					super.determineStep();
					i=true;
				}
			super.move(Aquarium.FOODWIDTH, Aquarium.FOODWIDTH);
			}
			else
			{
				i=false;
				super.move(Aquarium.WIDTH, Aquarium.HEIGHT);
			}
			if(getX()<Aquarium.FOODWIDTH&&getY()<Aquarium.FOODHEIGHT)//
			{
				for(int k=0;k<=s;k++)
				{
					if(fishFood.get(k).getL()&&getX()<Aquarium.FOODWIDTH+1&&getY()<Aquarium.FOODHEIGHT+1&&hungerMeter!=0)
					{
						hungerMeter--;
						if(hungerMeter<500)
						{
						progress.change(1);
						}
						if(alt>temp.getRed()&&hungerMeter<500)
						{
						alt--;
						setColor(new Color(alt,temp.getGreen(),temp.getBlue()));
						}
						if(count>0)
						count--;
						break;
					}
				}

				
			}
			else
			{
				hungerMeter++;
				if(alt<255&&count%2==0)
				{
				alt++;
				setColor(new Color(alt,temp.getGreen(),temp.getBlue()));
				}
				if(progress.getLength()>0)
				{
					progress.change(-1);
				}
				count++;


			}
			//have look
		
			s++;


	}
	public void drawBar(Graphics2D g)
	{
		back.draw(g);
		progress.draw(g);
	}
	
	public void draw(Graphics2D g)
	{
		drawBar(g);
		
		for(int x=0;x<s;x++)
		{
			fishFood.get(x).draw(g);//!
			fishFood.get(x).fall();
		}
		if(s>=fishFood.size())
		{
			s=0;
		}

		super.draw(g);
		
		
	}
	
	public void drawFood(Graphics2D g)
	{
		fishFood.get(s).draw(g);
	}

}
